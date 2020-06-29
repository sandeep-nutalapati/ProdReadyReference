package com.deloitte.prod.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.prod.application.model.ExchangeValue;
import com.deloitte.prod.application.model.ProdDetail;
import com.deloitte.prod.application.service.CurrencyExchangeService;

@RestController
//@RequestMapping("/invoked-service")
public class InvokedController {

	private static final Logger LOG = LoggerFactory.getLogger(InvokedController.class);
	
	@Autowired
	private CurrencyExchangeService exchangeService;
	
	@RequestMapping(value = "/intializeInvokedService", method = RequestMethod.GET)
	public String intializeInvokedService() {
		LOG.debug( "Invoked controller is being called");
		return "success";
	}

	@RequestMapping(value = "/addServiceDetails", method = RequestMethod.POST)
	public String saveServiceDetails(@RequestBody ProdDetail detaills) {
		LOG.debug( "saveServiceDetails is being called");
		return "details saved";
	}
	

	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue exchage(HttpServletRequest request, @PathVariable String from, @PathVariable String to) {
		LOG.debug("{}",request);
		return exchangeService.exchage(request, from, to);
	}

}
