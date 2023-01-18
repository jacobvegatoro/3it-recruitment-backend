package com.tresit.msrecruitment.commons.clientes.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cliente_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Cliente cliente;

	//@JsonManagedReference
	//@JsonIgnore
	//@OneToMany(fetch = FetchType.LAZY)
	//private List <Entrevista> entrevistas;

	/*public void addCliente(Cliente cliente) 
	{
		this.cliente = cliente;
	}
	
	public void removeCliente(Cliente cliente) {
		this.cliente = null;
	}*/
	
}
