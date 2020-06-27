package com.deloitte.prod.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.prod.model.ProdDetail;

@RestController
@RequestMapping("/invoked-service")
public class InvokerController {
	
	private static final Logger LOG = Logger.getLogger(InvokerController.class.getName());
	
	@Autowired
	private RestTemplate restTemplate;

	
    @RequestMapping(value = "/intializeInvokerService", method= RequestMethod.GET)
	public String intializeInvokerService() {
		LOG.log(Level.INFO, "Invoker controller is being called");
		return "success";
	}
    
    @RequestMapping(value = "/saveServiceDetails", method = RequestMethod.POST)
	public String saveServiceDetails(@RequestBody ProdDetail detaills) {
		LOG.log(Level.INFO, "saveServiceDetails is being called");
		String response = restTemplate.postForObject("http://localhost:8090/invoked-service/addServiceDetails", detaills, String.class);
		return response;
	}

}
