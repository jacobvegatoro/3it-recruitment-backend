package com.tresit.msrecruitment.commons.clientes.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "celula_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Celula celula;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "postulante_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Postulante postulante;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "rol_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Rol rol;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Usuario usuario;
	
	/*
	@OneToMany(fetch = FetchType.LAZY)
	@JsonManagedReference
	private List <Respuesta> respuestas;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonManagedReference
	private List <EstadoEntrevista> estadosentrevistas;
	*/

}
