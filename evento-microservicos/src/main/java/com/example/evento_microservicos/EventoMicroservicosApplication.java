package com.example.evento_microservicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EventoMicroservicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventoMicroservicosApplication.class, args);
	}

}
