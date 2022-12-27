package com.tresit.msrecruitment.commons.clientes.models.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	private Celula celula;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	private Postulante postulante;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	private Rol rol;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonManagedReference
	private List <Respuesta> respuestas;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonManagedReference
	private List <EstadoEntrevista> estadosentrevistas;

}
