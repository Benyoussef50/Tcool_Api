package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.domain.Notification;

public interface CompteService {

	public Compte save(Compte c);
	public void delete(Long id);
	public Compte getById(Long id);
	public List<Compte> getAllCompte();
	public List<Compte> getAllIntervenants();
	public List<Compte> addNotifsToSyndic(Notification n);
	public List<Compte> addNotifsToInter(Notification n);
	public List<Compte> addNotifsToResid(Notification n);
	public Compte notifierActeur(Notification n,Long id);
}
