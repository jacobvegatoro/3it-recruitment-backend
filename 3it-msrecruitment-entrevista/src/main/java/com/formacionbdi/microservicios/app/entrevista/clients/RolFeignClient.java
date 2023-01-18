package com.formacionbdi.microservicios.app.entrevista.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tresit.msrecruitment.commons.clientes.models.entity.Rol;

@FeignClient(name="3it-msrecruitment-pregunta", url="http://localhost:8090/api/preres/roles")
public interface RolFeignClient {

	@GetMapping("/{id}")
	public Rol obtenerRol(@PathVariable Long id);

}
