package com.tresit.msrecruitment.commons.clientes.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	private Entrevista entrevista;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	private Pregunta pregunta;

	/*second getters 
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}*/
	
}
