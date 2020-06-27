package com.deloitte.prod.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProdServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdServiceRegistryApplication.class, args);
	}
}
