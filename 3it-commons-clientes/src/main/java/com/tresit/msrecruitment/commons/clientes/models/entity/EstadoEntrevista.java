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
@Table(name="estadosentrevistas")
public class EstadoEntrevista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "entrevista_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Entrevista entrevista;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "estado_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Estado estado;

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

}
