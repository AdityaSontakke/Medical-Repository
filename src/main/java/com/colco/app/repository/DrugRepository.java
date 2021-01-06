package com.colco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.colco.app.entity.DrugEntity;

public interface DrugRepository extends JpaRepository<DrugEntity, Integer>{

}
