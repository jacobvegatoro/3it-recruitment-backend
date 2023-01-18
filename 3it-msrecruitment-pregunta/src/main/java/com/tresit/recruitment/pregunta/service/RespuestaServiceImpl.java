package com.tresit.recruitment.pregunta.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresit.msrecruitment.commons.clientes.models.entity.Entrevista;
import com.tresit.msrecruitment.commons.clientes.models.entity.Respuesta;
import com.tresit.recruitment.pregunta.clients.EntrevistaFeignClient;
import com.tresit.recruitment.pregunta.model.repository.RespuestaRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService {

	@Autowired
	private EntrevistaFeignClient entrevistaClient;

	@Autowired
	private RespuestaRepository repository;

	@Override
	public Iterable<Respuesta> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Respuesta> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Respuesta save(Respuesta respuesta) {
		return repository.save(respuesta);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Entrevista obtenerEntrevista(Long id) {
		return entrevistaClient.obtenerEntrevista(id);
	}

}
