package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Compte;

public interface CompteService {

	public Compte save(Compte c);
	public void delete(Long id);
	public Compte getById(Long id);
	public List<Compte> getAllCompte();
	public List<Compte> getAllIntervenants();
}
