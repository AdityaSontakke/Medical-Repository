package com.colco.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class MedicalRepresentativeEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Email")
	private String email;

	@OneToMany(targetEntity = DrugEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "md_fk", referencedColumnName = "id")
	private List<DrugEntity> drugs;

}
