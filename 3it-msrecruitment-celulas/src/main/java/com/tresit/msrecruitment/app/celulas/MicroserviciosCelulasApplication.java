package com.tresit.msrecruitment.app.celulas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.tresit.msrecruitment.commons.clientes.models.entity",
	"com.tresit.msrecruitment.app.celulas.models.entity"})
public class MicroserviciosCelulasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCelulasApplication.class, args);
	}

}
