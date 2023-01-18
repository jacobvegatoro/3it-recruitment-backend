package com.formacionbdi.microservicios.app.entrevista.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.entrevista.clients.CelulaFeignClient;
import com.formacionbdi.microservicios.app.entrevista.clients.PostulanteFeignClient;
import com.formacionbdi.microservicios.app.entrevista.clients.RolFeignClient;
import com.formacionbdi.microservicios.app.entrevista.clients.UsuarioFeignClient;
import com.formacionbdi.microservicios.app.entrevista.models.repository.EntrevistaRepository;
import com.tresit.microservicios.commons.services.CommonServiceImpl;
import com.tresit.msrecruitment.commons.clientes.models.entity.Celula;
import com.tresit.msrecruitment.commons.clientes.models.entity.Entrevista;
import com.tresit.msrecruitment.commons.clientes.models.entity.Postulante;
import com.tresit.msrecruitment.commons.clientes.models.entity.Rol;
import com.tresit.msrecruitment.commons.clientes.models.entity.Usuario;

@Service
public class EntrevistaServiceImpl extends CommonServiceImpl<Entrevista, EntrevistaRepository> implements EntrevistaService {

	@Autowired
	private CelulaFeignClient celulaClient;

	@Autowired
	private PostulanteFeignClient postulanteClient;

	@Autowired
	private RolFeignClient rolClient;

	@Autowired
	private UsuarioFeignClient usuarioClient;

	@Override
	public Celula ver(Long id) {
		return celulaClient.ver(id);
	}

	@Override
	public Postulante obtener(Long id) {
		return postulanteClient.obtener(id);
	}

	@Override
	public Rol obtenerRol(Long id) {
		return rolClient.obtenerRol(id);
	}

	@Override
	public Usuario obtenerUsuario(Long id) {
		return usuarioClient.obtenerUsuario(id);
	}

}

