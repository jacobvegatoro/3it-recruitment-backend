package com.tresit.recruitment.pregunta.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tresit.recruitment.pregunta.model.entity.Rol;

public interface RolRepository extends PagingAndSortingRepository<Rol, Long> {

}
