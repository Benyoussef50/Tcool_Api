package com.kf2y.tcool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kf2y.tcool.domain.Compte;



public interface CompteRepository extends JpaRepository<Compte, Long> {

	public Compte findByEmail(String email);
	public Boolean existsByEmail(String email);
}
