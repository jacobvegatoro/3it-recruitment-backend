package com.tresit.msrecruitment.app.celulas.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tresit.msrecruitment.app.celulas.models.entity.Celula;


public interface CelulaRepository extends PagingAndSortingRepository<Celula, Long> {
	
	@Query("select c from Celula c join fetch c.clientes a where a.id=?1")
	public Celula findCelulaByClienteId(Long id);

}
