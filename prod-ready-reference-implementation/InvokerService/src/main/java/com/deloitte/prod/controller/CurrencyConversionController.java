package com.deloitte.prod.controller;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.prod.model.CurrencyConversionDto;
import com.deloitte.prod.model.ProdDetail;
import com.deloitte.prod.service.CurrencyConversionService;
import com.deloitte.prod.service.proxy.CurrencyExchangeServiceProxyViaZuul;

@RestController
//@RequestMapping("/invoked-service")
public class CurrencyConversionController {

	private static final Logger LOG = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyConversionService conversionService;

	@Autowired
	Environment environment;

	@RequestMapping(value = "/intializeInvokerService", method = RequestMethod.GET)
	public String intializeInvokerService() {
		LOG.info( "Invoker controller is being called");
		return "success";
	}

	@RequestMapping(value = "/saveServiceDetails", method = RequestMethod.POST)
	public String saveServiceDetails(@RequestBody ProdDetail detaills) {
		LOG.info( "saveServiceDetails is being called");
		String response = restTemplate.postForObject("http://localhost:8090/addServiceDetails", detaills, String.class);
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String backend() {
		System.out.println("Inside MyRestController::backend...");

		String serverPort = environment.getProperty("local.server.port");

		System.out.println("Port : " + serverPort);

		return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
	}
	
	
	@GetMapping(path="currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionDto convertCurrency(HttpServletRequest request, @PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		return conversionService.convertCurrencyRestClient(from, to, quantity);
	}

	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionDto convertCurrencyFeign(HttpServletRequest request, @PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		LOG.info("convertCurrencyFeign " + request);
		return conversionService.convertCurrencyFeign(from, to, quantity);
		
	}


}
