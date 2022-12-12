package com.formacionbdi.microservicios.app.estado.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.formacionbdi.microservicios.commons.entrevista.models.entity.Entrevista;

@Entity
@Table(name="estados")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreateAt;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Entrevista> entrevistas;
	
	@PrePersist
	public void prePersist() {
		this.CreateAt = new Date();
	}
	
	public Estado() {
		this.entrevistas = new ArrayList<>();
	}

	private String comentario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return CreateAt;
	}

	public void setCreateAt(Date createAt) {
		CreateAt = createAt;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public List<Entrevista> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(List<Entrevista> entrevistas) {
		this.entrevistas = entrevistas;
	}
	
	public void addEntrevista(Entrevista entrevista) {
		this.entrevistas.add(entrevista);
	}
	
	public void removeEntrevista(Entrevista entrevista) {
		this.entrevistas.remove(entrevista);
	}

}
