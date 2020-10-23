package com.kf2y.tcool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kf2y.tcool.domain.Copropriete;
import com.kf2y.tcool.repository.CoproprieteRepository;

@Service
@Transactional
public class CoproprieteServiceImpl implements CoproprieteService {

	@Autowired
	private CoproprieteRepository coproprieteRepo;
	
	@Override
	public Copropriete save(Copropriete cop) {
		// TODO Auto-generated method stub
		return coproprieteRepo.save(cop);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		coproprieteRepo.deleteById(id);
	}

	@Override
	public List<Copropriete> getAllCopropriete() {
		// TODO Auto-generated method stub
		return coproprieteRepo.findAll();
	}

	@Override
	public Copropriete getById(Long id) {
		// TODO Auto-generated method stub
		Copropriete cop = coproprieteRepo.findById(id).orElse(null);
		if(cop == null) {
			throw new RuntimeException("Copropriété avec id= "+id+" introuvable!");
		} else return cop;
	}

	@Override
	public List<Copropriete> getByCompte(Long id) {
		// TODO Auto-generated method stub
		List<Copropriete> cop =  coproprieteRepo.findAllCopByCompte(id);
		if(cop == null) {
			throw new RuntimeException("Copropriété avec id= "+id+" introuvable!");
		} else return cop;
	}

}
