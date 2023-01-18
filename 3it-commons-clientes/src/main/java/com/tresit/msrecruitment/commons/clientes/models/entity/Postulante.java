package com.tresit.msrecruitment.commons.clientes.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="postulantes")
public class Postulante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String apellido;
	private String ciudad;
	private String enlaceBizneo;
	
	/*
	@OneToMany(fetch = FetchType.LAZY)
	@JsonManagedReference
	private List <Entrevista> entrevistas;
	*/
}
