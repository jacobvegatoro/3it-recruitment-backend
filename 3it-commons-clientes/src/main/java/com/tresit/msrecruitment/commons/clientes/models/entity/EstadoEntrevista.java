package com.tresit.msrecruitment.commons.clientes.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name="estadosentrevistas")
public class EstadoEntrevista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String comentario;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	private Entrevista entrevista;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	private Estado estado;

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

}
