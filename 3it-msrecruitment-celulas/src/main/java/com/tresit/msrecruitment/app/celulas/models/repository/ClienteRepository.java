package com.tresit.msrecruitment.app.celulas.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tresit.msrecruitment.commons.clientes.models.entity.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

	@Query("select a from Cliente a where a.nombre like %?1% or a.casaMatriz like %?1%")
	public List<Cliente> findByNombreOrCasaMatriz(String term);
	
}
