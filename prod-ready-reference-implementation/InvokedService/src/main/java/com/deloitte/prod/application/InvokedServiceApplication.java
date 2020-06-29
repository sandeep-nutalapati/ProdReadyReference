package com.deloitte.prod.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.deloitte.prod"})
@ComponentScan(basePackages = {"com.deloitte.prod"})
@EntityScan("com.deloitte.prod")
@EnableJpaRepositories("com.deloitte.prod.application.dao")
@EnableEurekaClient
@RefreshScope
public class InvokedServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvokedServiceApplication.class, args);
	}
}
