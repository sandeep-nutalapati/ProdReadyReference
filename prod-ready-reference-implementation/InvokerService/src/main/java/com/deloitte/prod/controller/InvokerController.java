package com.deloitte.prod.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoked-service")
public class InvokerController {
	
	private static final Logger LOG = Logger.getLogger(InvokerController.class.getName());
	
    @RequestMapping(value = "/intializeInvokerService", method= RequestMethod.GET)
	public String intializeInvokerService() {
		LOG.log(Level.INFO, "Invoker controller is being called");
		return "success";
	}

}
