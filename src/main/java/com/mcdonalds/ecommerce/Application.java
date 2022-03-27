package com.mcdonalds.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ConfigurationPropertiesScan(basePackages = {"com.mcdonalds.ecommerce.configuration"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
