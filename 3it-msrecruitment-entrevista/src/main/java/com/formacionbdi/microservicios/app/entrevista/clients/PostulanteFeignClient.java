package com.formacionbdi.microservicios.app.entrevista.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tresit.msrecruitment.commons.clientes.models.entity.Postulante;

@FeignClient(name="3it-msrecruitment-postulantes", url="http://localhost:8090/api/postulantes")
public interface PostulanteFeignClient {

	@GetMapping("/{id}")
	public Postulante obtener(@PathVariable Long id);

}
