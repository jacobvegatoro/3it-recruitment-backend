package com.tresit.recruitment.pregunta;
//DEBIERA SER COMO
//package com.formacionbdi.microservicios.app.preguta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//@EntityScan({"com.tresit.msrecruitment.commons.OBJECT.models.entity"})
@EnableEurekaClient
@SpringBootApplication
public class MicroservicioPreguntaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioPreguntaApplication.class, args);
	}

}
