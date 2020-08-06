package com.kf2y.tcool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.domain.Notification;
import com.kf2y.tcool.repository.CompteRepository;
import com.kf2y.tcool.service.exception.ElementNotFoundException;

import java.util.Optional;
import java.util.stream.Collectors;

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
	
	@Override
	public List<Compte> getAllSyndics() {
		// TODO Auto-generated method stub
		return compteRepo.findAllSynd();
	}

	@Override
	public List<Compte> addNotifsToSyndic(Notification n) {
		List<Compte> comptes = compteRepo.findAllSynd();
		for(Compte c : comptes) {
		   c.getMyNotifications().add(n);
		   	}
		return comptes;
	}

	@Override
	public List<Compte> addNotifsToInter(Notification n) {
		List<Compte> comptes = compteRepo.findAllIdInter();
		for(Compte c : comptes) {
		   c.getMyNotifications().add(n);
		   	}
		return comptes;
	}

	@Override
	public List<Compte> addNotifsToResid(Notification n) {
		List<Compte> comptes = compteRepo.findAllResid();
		for(Compte c : comptes) {
		   c.getMyNotifications().add(n);
		   	}
		return comptes;
	}

	@Override
	public Compte notifierActeur(Notification n, Long id) {
		Optional<Compte> compte = compteRepo.findById(id);
		if (compte.isPresent()) {
			Compte cpt =compte.get();
			cpt.getMyNotifications().add(n);
			return compteRepo.save(cpt);
		} else {
			throw new ElementNotFoundException(Compte.class, id);
		}
	}

	@Override
	public List<Notification> getNoReadNotif(Long id) {
		Optional<Compte> compte = compteRepo.findById(id);
		if (compte.isPresent()) {
			Compte cpt =compte.get();
			List<Notification> notifs = cpt.getMyNotifications();
			List<Notification> result = notifs.stream()
					.filter(n -> !n.isRead())  
	                .collect(Collectors.toList()); 
		return result;
		}else {
			throw new ElementNotFoundException(Compte.class, id);
		}
	}
	
	@Override
	public Compte getNoReadNotifcpt(Long id) {
		Optional<Compte> compte = compteRepo.findById(id);
		if (compte.isPresent()) {
			Compte cpt =compte.get();
			List<Notification> notifs = cpt.getMyNotifications();
			List<Notification> result = notifs.stream()
					.filter(n -> !n.isRead())  
	                .collect(Collectors.toList()); 
			cpt.setMyNotifications(result);
		return cpt;
		}else {
			throw new ElementNotFoundException(Compte.class, id);
		}
	}

	@Override
	public List<Notification> getReadNotif(Long id) {
		Optional<Compte> compte = compteRepo.findById(id);
		if (compte.isPresent()) {
			Compte cpt =compte.get();
			List<Notification> notifs = cpt.getMyNotifications();
			List<Notification> result = notifs.stream()
					.filter(n -> n.isRead())  
	                .collect(Collectors.toList()); 
		return result;
		}else {
			throw new ElementNotFoundException(Compte.class, id);
		}
	}

	@Override
	public Compte getByEmail(String email) {
		// TODO Auto-generated method stub
		return compteRepo.findByEmail(email);
	}

	@Override
	public Compte notifierActeurByEmail(Notification n, String email) {
		Compte compte = compteRepo.findByEmail(email);
		if (compte != null) {
			compte.getMyNotifications().add(n);
			return compteRepo.save(compte);
		} else {
			throw new RuntimeException("Could not find the user with email: " + email);
		}
	}


}
