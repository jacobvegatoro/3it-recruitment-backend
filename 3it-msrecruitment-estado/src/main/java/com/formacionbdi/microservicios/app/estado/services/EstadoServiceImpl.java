package com.formacionbdi.microservicios.app.estado.services;

import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.estado.models.entity.Estado;
import com.formacionbdi.microservicios.app.estado.models.repository.EstadoRepository;
import com.tresit.microservicios.commons.services.CommonServiceImpl;

@Service
public class EstadoServiceImpl extends CommonServiceImpl<Estado, EstadoRepository> implements EstadoService {


}
