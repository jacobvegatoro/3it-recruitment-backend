package com.formacionbdi.microservicios.app.entrevista.services;

import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.entrevista.models.repository.EntrevistaRepository;
import com.formacionbdi.microservicios.commons.entrevista.models.entity.Entrevista;
import com.tresit.microservicios.commons.services.CommonServiceImpl;

@Service
public class EntrevistaServiceImpl extends CommonServiceImpl<Entrevista, EntrevistaRepository> implements EntrevistaService {


}

