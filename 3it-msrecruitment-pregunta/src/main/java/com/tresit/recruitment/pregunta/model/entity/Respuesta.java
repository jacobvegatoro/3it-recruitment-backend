package com.tresit.recruitment.pregunta.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.tresit.recruitment.pregunta.model.entity.Pregunta;

/**
 * Si al momento de crear una "respuesta" 
 * debemos relacionarla a su Pregunta original
 * 
 * debemos relacionarla? Pregunta-<Respuesta
 *
 */

@Entity
@Table(name="respuestas")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String detalle;
	private Long puntaje;
	/*relation Pregunta-<Respuesta
	@JsonIgnoreProperties(value = {"respuesta"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pregunta_id")
	private Pregunta pregunta;*/

	//Getters and Setters
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
	public Long getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Long puntaje) {
		this.puntaje = puntaje;
	}
	/*second getters 
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}*/
}
