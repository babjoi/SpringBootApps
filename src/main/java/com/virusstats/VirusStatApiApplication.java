package com.virusstats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class VirusStatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirusStatApiApplication.class, args);
	}

}
