package com.tresit.msrecruitment.app.clientes.services;

import java.util.List;



import com.tresit.microservicios.commons.services.CommonService;
import com.tresit.msrecruitment.commons.clientes.models.entity.Cliente;


public interface ClienteService extends CommonService<Cliente> {
	
	public List<Cliente> findByNombreOrCasaMatriz(String term);


}
