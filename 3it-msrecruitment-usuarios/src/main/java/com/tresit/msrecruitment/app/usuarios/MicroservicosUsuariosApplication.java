package com.tresit.msrecruitment.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.tresit.msrecruitment.app.usuarios.models.entity"})
public class MicroservicosUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicosUsuariosApplication.class, args);
	}

}
