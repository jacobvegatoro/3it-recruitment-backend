package com.tresit.msrecruitment.commons.clientes.models.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name="celulas")
public class Celula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	//@OneToMany(fetch = FetchType.LAZY)
	//private List <Cliente> clientes;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY)
	private List <Entrevista> entrevistas;

	public void addCliente(Cliente cliente) 
	{
		this.cliente = cliente;
	}
	
	public void removeCliente(Cliente cliente) {
		this.cliente = null;
	}
	
}
