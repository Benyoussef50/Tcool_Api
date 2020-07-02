package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Intervention;

public interface InterventionService {

	
	
	/**
	 * Add new intervention
	 */
	public Intervention save(Intervention intervention);
	
	/**
	 * Update status
	 */
	public Intervention update(String status, Long id);

	/**
	 * Find by id
	 *
	 */
	public Intervention findInterventionById(Long id);

	/**
	 * 
	 */

	public List<Intervention> findAllIntervention();

	/**
	 * 
	 *
	 */
	public List<Intervention> findInterEnCours();

	/**
	 *
	 */

	public List<Intervention> findInterCloturees();

	/**
	 * 
	 */

	public List<Intervention> findInterAnnulees();

	/**
	 * Supprimer une intervention
	 */

	public void remove(Long id);

}
