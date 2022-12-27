package com.tresit.msrecruitment.app.celulas.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tresit.msrecruitment.commons.clientes.models.entity.Celula;

@Repository
public interface CelulaRepository extends PagingAndSortingRepository<Celula, Long> {
	
	//@Query("select c from Celula c join fetch c.clientes a where a.id=?1")
	//public Celula findCelulaByClienteId(Long id);

}
