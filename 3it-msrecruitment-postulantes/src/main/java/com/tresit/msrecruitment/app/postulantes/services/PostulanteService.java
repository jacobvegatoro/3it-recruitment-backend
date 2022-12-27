package com.tresit.msrecruitment.app.postulantes.services;

import java.util.Optional;

import com.tresit.msrecruitment.commons.clientes.models.entity.Postulante;


public interface PostulanteService {
	
	public Iterable<Postulante> findAll();
	
	public Optional<Postulante>findById(Long id);
	
	public Postulante save(Postulante postulante);
	
	public void deleteById(Long id);

}
