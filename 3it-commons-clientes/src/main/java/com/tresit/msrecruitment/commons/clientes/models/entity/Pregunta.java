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
@Table(name="preguntas")
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String detalle;
	private boolean activo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "rol_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Rol rol;
	
	/*@OneToMany(fetch = FetchType.LAZY)
	@JsonManagedReference
	private List <Respuesta> respuestas;

	relation Rol-<Pregunta
	@JsonIgnoreProperties(value = {"pregunta"}, allowSetters = true)
	@OneToMany(mappedBy = "pregunta", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Respuesta> respuestas;*/
	
	/*
	//Figure out if deleting cascading or not
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull 
	private Rol rol;*/
	
	/*necesitamos comparar Respuestas.. Source override equals
	public void removeRespuesta(Respuesta respuesta) {
		this.respuestas.remove(respuesta);
		respuesta.setPregunta(null); //to be deleted by orphanRemoval
	}*/
	
	/*
	public List<Respuesta> getRespuestas() { // because OneToMany relation
		return respuestas;
	}
	public void setRespuestas(List<Respuesta> respuestas) { //why?->En ejemplo "se crean examenes con preguntas
		this.respuestas.clear();
		respuestas.forEach(this::addRespuesta);
	}*/
	
	/*
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}*/
	
	
}
