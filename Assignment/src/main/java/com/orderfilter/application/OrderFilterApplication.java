package com.orderfilter.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.orderfilter")
public class OrderFilterApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderFilterApplication.class, args);
	}
}
