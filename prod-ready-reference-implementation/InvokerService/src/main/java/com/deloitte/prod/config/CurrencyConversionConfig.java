package com.deloitte.prod.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CurrencyConversionConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		RestTemplate template=new RestTemplate();
		return template;
	}
	
}
