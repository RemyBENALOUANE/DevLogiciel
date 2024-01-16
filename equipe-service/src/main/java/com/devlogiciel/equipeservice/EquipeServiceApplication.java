package com.devlogiciel.equipeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EquipeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipeServiceApplication.class, args);
	}

}
