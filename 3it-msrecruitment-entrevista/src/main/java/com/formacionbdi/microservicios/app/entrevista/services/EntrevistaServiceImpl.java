package com.formacionbdi.microservicios.app.entrevista.services;

import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.entrevista.models.repository.EntrevistaRepository;
import com.tresit.microservicios.commons.services.CommonServiceImpl;
import com.tresit.msrecruitment.commons.clientes.models.entity.Entrevista;

@Service
public class EntrevistaServiceImpl extends CommonServiceImpl<Entrevista, EntrevistaRepository> implements EntrevistaService {


}

