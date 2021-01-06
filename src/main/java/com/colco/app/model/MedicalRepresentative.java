package com.colco.app.model;

import java.util.List;

import com.colco.app.entity.DrugEntity;

import lombok.Data;

@Data
public class MedicalRepresentative {

	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private List<DrugEntity> drugs;
	
}
