package com.tresit.msrecruitment.commons.clientes.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

		//@JsonManagedReference
		//@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
		//@OneToMany(fetch = FetchType.LAZY)
		//private List <Celula> celulas;

}
