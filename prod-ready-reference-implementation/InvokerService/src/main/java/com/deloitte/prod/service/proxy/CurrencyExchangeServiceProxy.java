package com.deloitte.prod.service.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.prod.model.CurrencyConversionDto;

//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000")
//If you want all calls of currency-exchange-service to go via zuul
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
@Component
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionDto getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
