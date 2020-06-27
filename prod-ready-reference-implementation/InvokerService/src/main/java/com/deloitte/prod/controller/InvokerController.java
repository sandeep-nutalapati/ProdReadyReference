package com.deloitte.prod.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.prod.model.ProdDetail;

@RestController
//@RequestMapping("/invoked-service")
public class InvokerController {

	private static final Logger LOG = Logger.getLogger(InvokerController.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	Environment environment;

	@RequestMapping(value = "/intializeInvokerService", method = RequestMethod.GET)
	public String intializeInvokerService() {
		LOG.log(Level.INFO, "Invoker controller is being called");
		return "success";
	}

	@RequestMapping(value = "/saveServiceDetails", method = RequestMethod.POST)
	public String saveServiceDetails(@RequestBody ProdDetail detaills) {
		LOG.log(Level.INFO, "saveServiceDetails is being called");
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

}
