package com.formacionbdi.microservicios.app.entrevista.services;

import com.tresit.microservicios.commons.services.CommonService;
import com.tresit.msrecruitment.commons.clientes.models.entity.Celula;
import com.tresit.msrecruitment.commons.clientes.models.entity.Entrevista;
import com.tresit.msrecruitment.commons.clientes.models.entity.Postulante;
import com.tresit.msrecruitment.commons.clientes.models.entity.Rol;
import com.tresit.msrecruitment.commons.clientes.models.entity.Usuario;

public interface EntrevistaService extends CommonService<Entrevista> {

	public Celula ver(Long id);
	
	public Postulante obtener(Long id);

	public Rol obtenerRol(Long id);

	public Usuario obtenerUsuario(Long id);
	
}
