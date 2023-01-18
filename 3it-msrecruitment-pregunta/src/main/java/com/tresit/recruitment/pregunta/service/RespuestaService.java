package com.tresit.recruitment.pregunta.service;

import java.util.Optional;

import com.tresit.msrecruitment.commons.clientes.models.entity.Entrevista;
import com.tresit.msrecruitment.commons.clientes.models.entity.Respuesta;

public interface RespuestaService {

    public Iterable<Respuesta> findAll();
   
	public Optional<Respuesta>findById(Long id);
	
	public Respuesta save(Respuesta respuesta);
	
	public void deleteById(Long id);

	public Entrevista obtenerEntrevista(Long id);

}
