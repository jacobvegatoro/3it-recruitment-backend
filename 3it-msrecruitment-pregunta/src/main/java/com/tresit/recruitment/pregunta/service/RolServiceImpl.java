package com.tresit.recruitment.pregunta.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresit.msrecruitment.commons.clientes.models.entity.Rol;
import com.tresit.recruitment.pregunta.model.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository repository;
	
	@Override
	public Iterable<Rol> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Rol> findById(Long id) {
		return repository.findById(id); 
	}

	@Override
	public Rol save(Rol rol) {
		return repository.save(rol);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
