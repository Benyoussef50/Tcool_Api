package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kf2y.tcool.domain.Evenement;


public interface EvenementRepository extends JpaRepository<Evenement, Long>{
	public List<Evenement> findByStatus(String status); 
}
