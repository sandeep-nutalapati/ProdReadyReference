package com.deloitte.prod.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.prod.model.CurrencyConversionDto;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxyViaZuul {


	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionDto getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}


