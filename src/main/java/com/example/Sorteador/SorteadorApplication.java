package com.example.Sorteador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class SorteadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SorteadorApplication.class, args);
	}

}
