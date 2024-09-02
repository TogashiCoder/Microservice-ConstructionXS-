package com.microservices.descovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

@EnableDiscoveryClient
public class RessourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RessourcesApplication.class, args);
	}

}
