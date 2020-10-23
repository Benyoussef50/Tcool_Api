package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.domain.Copropriete;
import com.kf2y.tcool.domain.Notification;

public interface CompteService {

	public Compte save(Compte c);
	public void delete(Long id);
	public Compte getById(Long id);
	public Compte getByEmail(String email);
	public List<Compte> getAllCompte();
	public List<Compte> getAllIntervenants();
	public List<Compte> getAllGestionnaires();
	public List<Compte> addNotifsToGestionnaire(Notification n);
	public List<Compte> addNotifsToInter(Notification n);
	public List<Compte> addNotifsToResid(Notification n);
	public Compte notifierActeur(Notification n,Long id);
	public Compte notifierActeurByEmail(Notification n, String email);
	public List<Notification> getNoReadNotif(Long id);
	public Compte getNoReadNotifcpt(Long id);
	public List<Notification> getReadNotif(Long id);

}
