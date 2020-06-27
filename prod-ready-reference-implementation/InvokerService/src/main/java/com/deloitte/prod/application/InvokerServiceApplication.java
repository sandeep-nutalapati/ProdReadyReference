
package com.deloitte.prod.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.deloitte.prod.*")
@EnableDiscoveryClient
public class InvokerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvokerServiceApplication.class, args);
	}
	
	
	  @Bean public RestTemplate restTemplate(RestTemplateBuilder builder) { return
	  builder.build(); }
	 
}
