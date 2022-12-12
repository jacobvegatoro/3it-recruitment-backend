package com.formacionbdi.microservicios.commons.entrevista.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "entrevistas")
public class Entrevista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	private String perfilBuscado;
	private String comentariosPrueba;
	private String comentariosGenerales;
	private String recomendaciones;
	private String descripcionPersonal;
	private String preguntasCandidato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getPerfilBuscado() {
		return perfilBuscado;
	}

	public void setPerfilBuscado(String perfilBuscado) {
		this.perfilBuscado = perfilBuscado;
	}

	public String getComentariosPrueba() {
		return comentariosPrueba;
	}

	public void setComentariosPrueba(String comentariosPrueba) {
		this.comentariosPrueba = comentariosPrueba;
	}

	public String getComentariosGenerales() {
		return comentariosGenerales;
	}

	public void setComentariosGenerales(String comentariosGenerales) {
		this.comentariosGenerales = comentariosGenerales;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	public String getDescripcionPersonal() {
		return descripcionPersonal;
	}

	public void setDescripcionPersonal(String descripcionPersonal) {
		this.descripcionPersonal = descripcionPersonal;
	}

	public String getPreguntasCandidato() {
		return preguntasCandidato;
	}

	public void setPreguntasCandidato(String preguntasCandidato) {
		this.preguntasCandidato = preguntasCandidato;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Entrevista)) {
			return false;
		}
		Entrevista a = (Entrevista) obj;
		
		return this.id != null && this.id.equals(a.getId());
	}	
}
