package com.tresit.recruitment.pregunta.service;

import java.util.Optional;

import com.tresit.msrecruitment.commons.clientes.models.entity.Pregunta;

public interface PreguntaService {
	
    public Iterable<Pregunta> findAll();
	public Optional<Pregunta>findById(Long id);
	public Pregunta save(Pregunta pregunta);
	public void deleteById(Long id);
	
}