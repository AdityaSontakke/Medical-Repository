package com.colco.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MedicalRepresentativeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalRepresentativeProjectApplication.class, args);
	}

}
