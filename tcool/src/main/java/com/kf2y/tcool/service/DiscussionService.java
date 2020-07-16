package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Discussion;
import com.kf2y.tcool.domain.Message;


public interface DiscussionService {

	public Discussion save( Discussion discussion);
	
	public void delete(Long id);
	
	public Discussion getById(Long id);
	
	public List<Discussion> getAllDiscussions();
	
	// liste des discussions en cours
	public List<Discussion> getDiscussionEnCours();
	
	// liste des discussions clôturées
	public List<Discussion> getDiscussionCloturees();
	
	// liste des discussions rejetées
	public List<Discussion> getDiscussionRejetees();
	
	public Discussion addMessages(Long id, Message msg);


}
