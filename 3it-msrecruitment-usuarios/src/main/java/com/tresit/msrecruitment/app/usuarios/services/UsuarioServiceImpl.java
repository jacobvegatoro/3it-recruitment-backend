package com.tresit.msrecruitment.app.usuarios.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tresit.microservicios.commons.services.CommonServiceImpl;
import com.tresit.msrecruitment.app.usuarios.models.entity.Usuario;
import com.tresit.msrecruitment.app.usuarios.models.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository> implements UsuarioService {

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}
	

}
