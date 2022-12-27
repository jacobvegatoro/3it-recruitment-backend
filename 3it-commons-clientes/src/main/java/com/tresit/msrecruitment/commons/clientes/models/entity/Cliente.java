package com.tresit.msrecruitment.commons.clientes.models.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name="clientes")
public class Cliente {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		private String nombre;
		
		private String casaMatriz;		

		@OneToMany(fetch = FetchType.LAZY)
		@JsonManagedReference
		private List <Celula> celulas;

}
