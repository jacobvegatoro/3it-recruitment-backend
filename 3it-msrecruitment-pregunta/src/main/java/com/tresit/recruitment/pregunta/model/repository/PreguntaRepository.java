package com.tresit.recruitment.pregunta.model.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tresit.recruitment.pregunta.model.entity.Pregunta;

//public interface PreguntaRepository extends CrudRepository<Pregunta, Long> {
public interface PreguntaRepository extends PagingAndSortingRepository<Pregunta, Long> {

}
