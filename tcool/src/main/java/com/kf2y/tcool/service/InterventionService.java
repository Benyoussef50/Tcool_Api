package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Intervention;
import com.kf2y.tcool.domain.Message;

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
	 * create CR for intervention
	 */
	public Intervention createCRIntervention(String status, String cr, Long id);
	
	/**
	 * create CR for intervention
	 */
	public Intervention evaluateIntervention(String status, String evaluation, Long id);

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
	
	public List<Intervention> getOwnerInterventions(String createdBy, String status);
	
	public List<Intervention> getOwnerInterventionsInProgress(String createdBy);

	/**
	 * Supprimer une intervention
	 */

	public void remove(Long id);
	public Intervention addMessages(Long id, Message msg);

}
 