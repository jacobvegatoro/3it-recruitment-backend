package com.tresit.recruitment.pregunta.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tresit.msrecruitment.commons.clientes.models.entity.Pregunta;
import com.tresit.recruitment.pregunta.model.repository.PreguntaRepository;

@Service
public class PreguntaServiceImpl implements PreguntaService {
	
	@Autowired
	private PreguntaRepository repository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Pregunta> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Pregunta> findById(Long id) {
		return repository.findById(id); 
	}

	@Override
	@Transactional
	public Pregunta save(Pregunta pregunta) {
		return repository.save(pregunta);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
