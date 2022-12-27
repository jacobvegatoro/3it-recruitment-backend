package com.tresit.msrecruitment.app.postulantes.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tresit.msrecruitment.commons.clientes.models.entity.Postulante;

@Repository
public interface PostulanteRepository extends CrudRepository<Postulante, Long> {

}
