package com.formacionbdi.microservicios.app.entrevista.services;

import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.entrevista.models.repository.EstadoRepository;
import com.tresit.microservicios.commons.services.CommonServiceImpl;
import com.tresit.msrecruitment.commons.clientes.models.entity.Estado;

@Service
public class EstadoServiceImpl extends CommonServiceImpl<Estado, EstadoRepository> implements EstadoService {

}
