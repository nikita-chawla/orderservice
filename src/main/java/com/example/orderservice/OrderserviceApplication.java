package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrderserviceApplication {
	private static final Logger logger = LoggerFactory.getLogger(OrderserviceApplication.class);

	public static void main(String[] args) {
		logger.info("Starting OrderserviceApplication...");
		SpringApplication.run(OrderserviceApplication.class, args);
		logger.info("OrderserviceApplication started.");
	}
}