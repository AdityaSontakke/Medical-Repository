package com.colco.app.service;

import java.util.List;

import com.colco.app.model.MedicalRepresentative;
import com.colco.app.model.Response;

public interface MRService {


	public boolean createMR(MedicalRepresentative medicalRepresentative);
	
	public boolean updateMR(Integer id, MedicalRepresentative medicalRepresentative);
	
	public List<MedicalRepresentative> getAllMR();
	
	public MedicalRepresentative getMRById(Integer id);
	
	public boolean deleteMRById(Integer id);


	public List<Response> getJoinInformation();




}
