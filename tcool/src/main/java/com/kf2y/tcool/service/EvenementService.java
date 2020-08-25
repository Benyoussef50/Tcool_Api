package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Evenement;
import com.kf2y.tcool.domain.Message;

public interface EvenementService {
	/**
	 *
	 */
	public Evenement save(Evenement evenement);
	/**
	 *
	 */	
	public Evenement update(String status, Long id);
	/**
	 *
	 */	
	public Evenement findEvenementById(Long id);
	/**
	 *
	 */
	public List<Evenement> findEventsEnCours();
	/**
	 *
	 */
	public List<Evenement> findEventsCloturees();
	/**
	 *
	 */
	public List<Evenement> findEventsRejetees();
	/**
	 *
	 */
	public List<Evenement> findAllEvents();
	
	public List<Evenement> getOwnerEvents(String createdBy, String status);
	
	public List<Evenement> getOwnerEventsInProgress(String createdBy);
	/**
	 *
	 */
	public void remove(Long id);
	/**
	 *
	 */
	public Evenement addMessages(Long id, Message msg);
		
	
	
	
}
