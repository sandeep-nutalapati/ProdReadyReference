
package com.deloitte.prod.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.deloitte.prod.*")
@EnableFeignClients("com.deloitte.prod.service")
@EnableEurekaClient
@EnableCircuitBreaker
@RefreshScope
public class InvokerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvokerServiceApplication.class, args);
	}
	
	 
}
