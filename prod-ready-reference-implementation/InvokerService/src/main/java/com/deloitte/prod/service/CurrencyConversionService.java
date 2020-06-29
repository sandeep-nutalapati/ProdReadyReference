package com.deloitte.prod.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deloitte.prod.config.CurrencyConfigurationProperties;
import com.deloitte.prod.model.CurrencyConversionDto;
import com.deloitte.prod.service.proxy.CurrencyExchangeServiceProxy;
import com.deloitte.prod.service.proxy.CurrencyExchangeServiceProxyViaZuul;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class CurrencyConversionService {

	private Logger logger=LoggerFactory.getLogger(CurrencyConversionService.class);
	
	@Autowired
	private CurrencyExchangeServiceProxy exchangeServiceProxy;
	
	@Autowired
	private CurrencyExchangeServiceProxyViaZuul exchangeServiceProxyZuul;
	
	@Autowired
	private RestTemplate restTemplate;

	private int count=1;
	
	@Value("${currency-conversion-service.exchange-url}")
	private String exchangeUrl;
	
	@Autowired
	private CurrencyConfigurationProperties configProps;
	
	public CurrencyConversionDto convertCurrencyRestClient(String from,
			String to, BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		logger.info("EXcahnge service url"+ exchangeUrl);
		CurrencyConversionDto entity = restTemplate
				.getForEntity(exchangeUrl+"currency-exchange/from/{from}/to/{to}",
						CurrencyConversionDto.class, uriVariables)
				.getBody();
		CurrencyConversionDto response = new CurrencyConversionDto(entity.getId(), from, to,
				entity.getConversionMultiple(), quantity, quantity.multiply(entity.getConversionMultiple()));
		response.setPort(entity.getPort());
		return response;
	}
	
	public CurrencyConversionDto convertCurrencyFeign(String from,
			String to, BigDecimal quantity) {
		
		CurrencyConversionDto entity = exchangeServiceProxy.getExchangeValue(from, to);
		CurrencyConversionDto response = new CurrencyConversionDto(entity.getId(), from, to,
				entity.getConversionMultiple(), quantity, quantity.multiply(entity.getConversionMultiple()));
		response.setPort(entity.getPort());
		return response;
	}
	
	@HystrixCommand(fallbackMethod = "convertCurrencyFallbackHystrix", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), 
	        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000")
			
	})
	public CurrencyConversionDto convertCurrencyHystrix(String from,
			String to, BigDecimal quantity) {
		
		CurrencyConversionDto entity = exchangeServiceProxy.getExchangeValue(from, to);
		CurrencyConversionDto response = new CurrencyConversionDto(entity.getId(), from, to,
				entity.getConversionMultiple(), quantity, quantity.multiply(entity.getConversionMultiple()));
		response.setPort(entity.getPort());
		if(count%2==0) {
			throw new RuntimeException("Throwing error");
		}
		count++;
		return response;
	}
	
	public CurrencyConversionDto convertCurrencyFallbackHystrix(String from,
			String to, BigDecimal quantity) {
		count++;
		return new CurrencyConversionDto(0, from, to, new BigDecimal(100), quantity, new BigDecimal(0));
	}
	
	public CurrencyConversionDto convertCurrencyZuul(String from,
			String to, BigDecimal quantity) {
		
		CurrencyConversionDto entity = exchangeServiceProxyZuul.getExchangeValue(from, to);
		CurrencyConversionDto response = new CurrencyConversionDto(entity.getId(), from, to,
				entity.getConversionMultiple(), quantity, quantity.multiply(entity.getConversionMultiple()));
		response.setPort(entity.getPort());
		return response;
	}
}
