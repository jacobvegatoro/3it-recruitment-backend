package com.tresit.msrecruitment.app.postulantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.tresit.msrecruitment.commons.clientes.models.entity"})
public class MicroserviciosPostulanteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPostulanteApplication.class, args);
	}

}
