package com.tresit.msrecruitment.app.pdf.model;

import javax.persistence.Column;
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
@Table(name = "templates")
public class Template {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;

	  @Column(name = "name")
	  private String name;

	  @Column(name = "detail")
	  private String detail;

}