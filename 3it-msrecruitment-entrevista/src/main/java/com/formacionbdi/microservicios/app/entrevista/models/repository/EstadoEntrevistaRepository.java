package com.formacionbdi.microservicios.app.entrevista.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tresit.msrecruitment.commons.clientes.models.entity.EstadoEntrevista;

@Repository
public interface EstadoEntrevistaRepository extends PagingAndSortingRepository<EstadoEntrevista, Long> {

}
