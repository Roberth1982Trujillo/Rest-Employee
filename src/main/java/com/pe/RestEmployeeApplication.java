package com.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestEmployeeApplication.class, args);
		System.out.println("Iniciado: Employee Service");
	}

}
