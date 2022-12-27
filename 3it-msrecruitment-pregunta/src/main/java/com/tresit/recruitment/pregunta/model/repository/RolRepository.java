package com.tresit.recruitment.pregunta.model.repository;

//import org.springframework.data.repository.CrudRepository; never used
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tresit.msrecruitment.commons.clientes.models.entity.Rol;

public interface RolRepository extends PagingAndSortingRepository<Rol, Long> {

}
