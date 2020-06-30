package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kf2y.tcool.domain.Intervention;

public interface InterventionRepository extends JpaRepository<Intervention, Long>{
	
	public List<Intervention> findByStatus(String status);
}
