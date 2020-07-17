package com.kf2y.tcool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.repository.CompteRepository;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {

	@Autowired
	private CompteRepository compteRepo;
	
	@Override
	public Compte save(Compte c) {
		// TODO Auto-generated method stub
		return compteRepo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		compteRepo.deleteById(id);
	}

	@Override
	public Compte getById(Long id) {
		// TODO Auto-generated method stub
		return compteRepo.findById(id).orElse(null);
	}

	@Override
	public List<Compte> getAllCompte() {
		// TODO Auto-generated method stub
		return compteRepo.findAll();
	}

	@Override
	public List<Compte> getAllIntervenants() {
		// TODO Auto-generated method stub
		return compteRepo.findAllIdInter();
	}

}
