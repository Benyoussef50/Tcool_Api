package com.kf2y.tcool.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf2y.tcool.domain.Intervention;
import com.kf2y.tcool.repository.InterventionRepository;

@Service
@Transactional
public class InterventionServiceImpl implements InterventionService {

	@Autowired
	private InterventionRepository interventionRepository;

	@Override
	public Intervention save(Intervention intervention) {

		return interventionRepository.save(intervention);
	}

	@Override
	public Intervention findInterventionById(Long id) {

		return interventionRepository.findById(id).orElse(null);
	}

	@Override
	public List<Intervention> findAllIntervention() {

		return interventionRepository.findAll();
	}

	@Override
	public List<Intervention> findInterEnCours() {

		return interventionRepository.findByStatus("EN COURS");
	}

	@Override
	public List<Intervention> findInterCloturees() {

		return interventionRepository.findByStatus("CLOTUREE");
	}

	@Override
	public List<Intervention> findInterAnnulees() {

		return interventionRepository.findByStatus("ANNULEE");
	}

	@Override
	public void remove(Long id) {
		interventionRepository.deleteById(id);

	}

}
