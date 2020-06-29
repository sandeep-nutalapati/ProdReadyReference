package com.deloitte.prod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonClientController {

	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/")
	public String health() {
		
		String randomString = null;
		try {
			randomString= this.restTemplate.getForObject("http://currency-conversion-service", String.class);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "Response :: " + randomString;
	}
}
