package com.tresit.recruitment.pregunta.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.tresit.microservicios.commons.recruitment.models.entity.Pregunta;

/** relaciones para tener en mente Rol-<Pregunta-<Respuesta
 * 1-
 * 
 * 
 */

@Entity
@Table(name="preguntas")
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String detalle;
	private boolean activo;
	
	/*relation Rol-<Pregunta
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
	
	//Getters and Setters start then 
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
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
	
	//para comparar en remove
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Pregunta)) {
			return false;
		}
		Pregunta a = (Pregunta) obj;
		return this.id != null && this.id.equals(a.getId()); //The operator != is undefined for the argument type(s) long, null
	}
}
