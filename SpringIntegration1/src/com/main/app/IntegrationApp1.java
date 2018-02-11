package com.main.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:int-config.xml")
public class IntegrationApp1 {
	public static void main(String[] args) {
		SpringApplication.run(IntegrationApp1.class, args);
	}
}
