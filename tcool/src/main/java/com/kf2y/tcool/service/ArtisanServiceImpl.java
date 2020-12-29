package com.kf2y.tcool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kf2y.tcool.domain.Artisan;
import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.exception.ResourceNotFoundException;
import com.kf2y.tcool.repository.ArtisanRepository;

@Service
@Transactional
public class ArtisanServiceImpl implements ArtisanService{
	
	@Autowired
	ArtisanRepository artisanRepository;

	@Override
	public Artisan save(Artisan a) {
		// TODO Auto-generated method stub
		return artisanRepository.save(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Artisan getById(Long id) {
		// TODO Auto-generated method stub
		Artisan artisan = artisanRepository.findById(id).orElse(null);
		if(artisan == null) {
			throw new RuntimeException("artisan avec id= "+id+" introuvable!");
			}  else return artisan;
	}

	@Override
	public Artisan getByDomaine(String domaine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artisan> getAllArtisans() {
		// TODO Auto-generated method stub
		return artisanRepository.findAll();
	}


}
