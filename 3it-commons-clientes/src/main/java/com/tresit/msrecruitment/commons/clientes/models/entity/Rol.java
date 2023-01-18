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
@Table(name="roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //long OR Long?
	
	private String detalle;

	/*
	@OneToMany(fetch = FetchType.LAZY)
	@JsonManagedReference
	private List <Pregunta> preguntas;

	@OneToMany(fetch = FetchType.LAZY)
	@JsonManagedReference
	private List <Entrevista> entrevistas;
	*/

	/*relation Rol-<Pregunta (aunque al crear un rol, no necesitamos tener todas las preguntas relacionadas a el
	@JsonIgnoreProperties(value = {"preguntas"}, allowSetters = true)
	@OneToMany(mappedBy = "preguntas", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pregunta> preguntas;*/
	
}
