package com.example.mitchellcoding;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

// @EnableJpaRepositories("com.exmaple.mitchellcoding.repository")
// @EntityScan("com.example.mitchellcoding.model")
@SpringBootApplication
public class MitchellCodingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MitchellCodingApplication.class, args);
	}
}
