
package com.deloitte.prod.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.deloitte.prod.*")
public class InvokerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvokerServiceApplication.class, args);
	}
}
