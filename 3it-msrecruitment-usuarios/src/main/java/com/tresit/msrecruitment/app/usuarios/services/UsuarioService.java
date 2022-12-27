package com.tresit.msrecruitment.app.usuarios.services;

import java.util.List;

import com.tresit.microservicios.commons.services.CommonService;
import com.tresit.msrecruitment.commons.clientes.models.entity.Usuario;

public interface UsuarioService extends CommonService<Usuario>{
	
	public List<Usuario> findByNombreOrApellido(String term);
}
