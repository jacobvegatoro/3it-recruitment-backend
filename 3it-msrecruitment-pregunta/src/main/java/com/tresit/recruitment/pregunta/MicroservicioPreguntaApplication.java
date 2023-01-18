package com.tresit.recruitment.pregunta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EntityScan({"com.tresit.msrecruitment.commons.clientes.models.entity"})
@EnableEurekaClient
@SpringBootApplication
public class MicroservicioPreguntaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioPreguntaApplication.class, args);
	}

}
