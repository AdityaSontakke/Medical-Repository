package com.colco.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.colco.app.entity.MedicalRepresentativeEntity;
import com.colco.app.model.MedicalRepresentative;
import com.colco.app.model.Response;

public interface MRRepository extends JpaRepository<MedicalRepresentativeEntity, Integer>{
	
	
	@Query("SELECT new com.colco.app.model.Response (m.firstName, m.lastName ) FROM MedicalRepresentativeEntity m JOIN m.drugs d")
	public List<Response> getJoinInformation();
	
}
