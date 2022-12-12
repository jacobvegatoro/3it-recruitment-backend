package com.formacionbdi.microservicios.app.entrevista.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formacionbdi.microservicios.commons.entrevista.models.entity.Entrevista;

public interface EntrevistaRepository extends PagingAndSortingRepository<Entrevista, Long>{

}
