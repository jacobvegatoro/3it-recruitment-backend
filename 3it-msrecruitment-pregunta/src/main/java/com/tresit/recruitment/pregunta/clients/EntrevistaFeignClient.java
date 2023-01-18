package com.tresit.recruitment.pregunta.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tresit.msrecruitment.commons.clientes.models.entity.Entrevista;

@FeignClient(name="3it-msrecruitment-entrevista", url="http://localhost:8090/api/entest/entrevistas")
public interface EntrevistaFeignClient {

	@GetMapping("/obtener/{id}")
	public Entrevista obtenerEntrevista(@PathVariable Long id);
	
}
