package com.formacionbdi.microservicios.app.estado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.formacionbdi.microservicios.commons.entrevista.models.entity",
	         "com.formacionbdi.microservicios.app.estado.models.entity"})
public class MicroserviciosEstadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosEstadoApplication.class, args);
	}

}
