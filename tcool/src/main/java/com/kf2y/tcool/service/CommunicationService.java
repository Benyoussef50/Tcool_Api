package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Communication;
import com.kf2y.tcool.domain.Discussion;



public interface CommunicationService {

	public Communication save(Communication com);
	public void delete(Long id);
	public Communication getById(Long id);
	List<Communication> getAllCommunications();
	List<Communication> getOwnerCommunication(String createdBy);
	//List<Communication> getCommunicationByCompte(Long id);
	List<Communication> getCommunicationByCopropriete(Long id);
}
