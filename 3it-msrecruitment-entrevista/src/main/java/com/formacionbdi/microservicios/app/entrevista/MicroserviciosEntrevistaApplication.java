package com.formacionbdi.microservicios.app.entrevista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.formacionbdi.microservicios.commons.entrevista.models.entity"})
public class MicroserviciosEntrevistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosEntrevistaApplication.class, args);
	}

}
