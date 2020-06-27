package com.deloitte.prod.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.prod.model.ProdDetail;

@RestController
//@RequestMapping("/invoked-service")
public class InvokedController {

	private static final Logger LOG = Logger.getLogger(InvokedController.class.getName());
	
	@RequestMapping(value = "/intializeInvokedService", method = RequestMethod.GET)
	public String intializeInvokedService() {
		LOG.log(Level.INFO, "Invoked controller is being called");
		return "success";
	}

	@RequestMapping(value = "/addServiceDetails", method = RequestMethod.POST)
	public String saveServiceDetails(@RequestBody ProdDetail detaills) {
		LOG.log(Level.INFO, "saveServiceDetails is being called");
		return "details saved";
	}

}
