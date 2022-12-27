package com.tresit.msrecruitment.app.postulantes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tresit.msrecruitment.app.postulantes.models.repository.PostulanteRepository;
import com.tresit.msrecruitment.commons.clientes.models.entity.Postulante;

@Service
public class PostulanteServiceImpl implements PostulanteService {
	
	@Autowired
	private 
	PostulanteRepository repository;

	@Override
	@Transactional
	public Iterable<Postulante> findAll() {
		
		return repository.findAll();
	}

	@Override
	@Transactional
	public Optional<Postulante> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Postulante save(Postulante postulante) {
		
		return repository.save(postulante);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		repository.deleteById(id);

	}

}
