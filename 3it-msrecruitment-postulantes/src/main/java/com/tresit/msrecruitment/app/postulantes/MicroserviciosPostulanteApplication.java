package com.tresit.msrecruitment.app.postulantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosPostulanteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPostulanteApplication.class, args);
	}

}
