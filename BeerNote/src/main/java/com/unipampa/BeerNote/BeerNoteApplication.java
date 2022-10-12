package com.unipampa.BeerNote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeerNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerNoteApplication.class, args);
	}

}
