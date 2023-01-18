package com.tresit.recruitment.pregunta.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tresit.msrecruitment.commons.clientes.models.entity.Pregunta;

public interface PreguntaRepository extends PagingAndSortingRepository<Pregunta, Long> {

}
