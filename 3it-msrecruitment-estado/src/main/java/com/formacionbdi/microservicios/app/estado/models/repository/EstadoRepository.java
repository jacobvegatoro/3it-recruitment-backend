package com.formacionbdi.microservicios.app.estado.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tresit.msrecruitment.commons.clientes.models.entity.Estado;

public interface EstadoRepository extends PagingAndSortingRepository<Estado, Long>{

}
