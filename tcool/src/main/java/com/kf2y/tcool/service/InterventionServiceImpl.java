package com.kf2y.tcool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.kf2y.tcool.domain.Intervention;
import com.kf2y.tcool.domain.Message;
import com.kf2y.tcool.repository.InterventionRepository;
import com.kf2y.tcool.service.exception.ElementNotFoundException;

@Service
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

	@Override
	public Intervention addMessages(Long id, Message msg) {
		Optional<Intervention> intervention = interventionRepository.findById(id);
		if (intervention.isPresent()) {
			Intervention inter = intervention.get();
			inter.getMsgInterventions().add(msg);
			return interventionRepository.save(inter);
		} else {
			throw new ElementNotFoundException(Intervention.class, id);

		}
	}

	@Transactional
	@Override
	public Intervention update(String status, Long id) {
		Optional<Intervention> intervention = interventionRepository.findById(id);
		if (intervention.isPresent()) {
			Intervention inter = intervention.get();
			inter.setStatus(status);
			return interventionRepository.save(inter);
		} else {
			throw new ElementNotFoundException(Intervention.class, id);
		}

	}

}
