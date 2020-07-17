package com.kf2y.tcool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf2y.tcool.domain.Evenement;
import com.kf2y.tcool.domain.Intervention;
import com.kf2y.tcool.domain.Message;
import com.kf2y.tcool.repository.EvenementRepository;
import com.kf2y.tcool.service.exception.ElementNotFoundException;

@Service
public class EvenementServiceImpl implements EvenementService {

	@Autowired
	private EvenementRepository evenementRepository;

	@Override
	public Evenement save(Evenement evenement) {

		return evenementRepository.save(evenement);
	}

	@Override
	public Evenement update(String status, Long id) {
		Optional<Evenement> evenement = evenementRepository.findById(id);
		if (evenement.isPresent()) {
			Evenement event = evenement.get();
			event.setStatus(status);
			return evenementRepository.save(event);
		} else {
			throw new ElementNotFoundException(Evenement.class, id);
		}
	}

	@Override
	public Evenement findEvenementById(Long id) {

		return evenementRepository.findById(id).orElse(null);
	}

	@Override
	public List<Evenement> findEventsEnCours() {

		return evenementRepository.findByStatus("EN COURS");
	}

	@Override
	public List<Evenement> findEventsCloturees() {

		return evenementRepository.findByStatus("CLOTUREE");
	}

	@Override
	public List<Evenement> findEventsRejetees() {

		return evenementRepository.findByStatus("REJETEE");
	}

	@Override
	public List<Evenement> findAllEvents() {

		return evenementRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		evenementRepository.deleteById(id);

	}

	@Override
	public Evenement addMessages(Long id, Message msg) {
		Optional<Evenement> evenement = evenementRepository.findById(id);
		if (evenement.isPresent()) {
			Evenement event = evenement.get();
			event.getMsgEvents().add(msg);
			return evenementRepository.save(event);
		} else {
			throw new ElementNotFoundException(Intervention.class, id);
		}
		
	}

}
