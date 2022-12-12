package com.tresit.recruitment.pregunta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioPreguntaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioPreguntaApplication.class, args);
	}

}
