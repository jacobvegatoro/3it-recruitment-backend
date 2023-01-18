package com.formacionbdi.microservicios.app.entrevista.services;

import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.entrevista.models.repository.EstadoEntrevistaRepository;
import com.tresit.microservicios.commons.services.CommonServiceImpl;
import com.tresit.msrecruitment.commons.clientes.models.entity.EstadoEntrevista;

@Service
public class EstadoEntrevistaServiceImpl extends CommonServiceImpl<EstadoEntrevista, EstadoEntrevistaRepository> implements EstadoEntrevistaService {

}
