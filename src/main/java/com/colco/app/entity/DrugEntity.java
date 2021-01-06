package com.colco.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DrugEntity {

	@Id
	@GeneratedValue
	@Column(name = "drugId")
	private Integer drugId;
	
	@Column(name = "drugName")
	private String drugName;


}
