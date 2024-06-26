package com.ClinicaApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Anotación que combina @Configuration, @EnableAutoConfiguration y @ComponentScan
public class ClinicaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApiApplication.class, args); // Método estático de SpringApplication para arrancar la aplicación Spring Boot
	}

}
