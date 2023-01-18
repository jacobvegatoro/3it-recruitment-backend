package com.formacionbdi.microservicios.app.entrevista.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tresit.msrecruitment.commons.clientes.models.entity.Celula;

@FeignClient(name="3it-msrecruitment-celulas", url="http://localhost:8090/api/celcli/celulas")
public interface CelulaFeignClient {

	@GetMapping("/{id}")
	public Celula ver(@PathVariable Long id);
	
}
