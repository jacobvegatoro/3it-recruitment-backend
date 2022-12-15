package com.tresit.recruitment.pregunta.model.entity;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.tresit.recruitment.pregunta.model.entity.Pregunta; dont have to import

@Entity
@Table(name="rols")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //long OR Long?
	
	private String detalle;
	
	/*relation Rol-<Pregunta (aunque al crear un rol, no necesitamos tener todas las preguntas relacionadas a el
	@JsonIgnoreProperties(value = {"preguntas"}, allowSetters = true)
	@OneToMany(mappedBy = "preguntas", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pregunta> preguntas;*/

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
}
