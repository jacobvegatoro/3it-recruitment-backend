package com.formacionbdi.microservicios.app.entrevista.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tresit.msrecruitment.commons.clientes.models.entity.Usuario;

@FeignClient(name="3it-msrecruitment-usuarios", url="http://localhost:8090/api/usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/obtener/{id}")
	public Usuario obtenerUsuario(@PathVariable Long id);
	
}
