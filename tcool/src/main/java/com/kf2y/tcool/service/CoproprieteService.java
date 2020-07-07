package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Copropriete;

public interface CoproprieteService {

	public Copropriete save(Copropriete cop);
	public void delete(Long id);
	public List<Copropriete> getAllCopropriete();
	public Copropriete getById(Long id);
}
