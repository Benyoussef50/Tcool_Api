package com.kf2y.tcool.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kf2y.tcool.domain.Discussion;
<<<<<<< HEAD

=======
import com.kf2y.tcool.domain.Intervention;
import com.kf2y.tcool.domain.Message;
>>>>>>> refs/remotes/origin/master
import com.kf2y.tcool.repository.DiscussionRepository;
import com.kf2y.tcool.service.exception.ElementNotFoundException;


@Service
@Transactional
public class DiscussionServiceImpl implements DiscussionService {

	@Autowired
	private DiscussionRepository discussRepo;

	@Override
	public Discussion save(Discussion discussion) {
		// TODO Auto-generated method stub
		return discussRepo.save(discussion);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		discussRepo.deleteById(id);
	}

	@Override
	public List<Discussion> getAllDiscussions() {
		// TODO Auto-generated method stub
		return discussRepo.findAll();
	}

	@Override
	public List<Discussion> getDiscussionEnCours() {
		// TODO Auto-generated method stub
		return discussRepo.findByStatus("EN COURS");
	}

	@Override
	public List<Discussion> getDiscussionCloturees() {
		// TODO Auto-generated method stub
		return discussRepo.findByStatus("CLOTUREE");
	}

	@Override
	public List<Discussion> getDiscussionRejetees() {
		// TODO Auto-generated method stub
		return discussRepo.findByStatus("REJETEE");
	}

	@Override
	public Discussion getById(Long id) {
		Discussion d = discussRepo.findById(id).orElse(null);
		if (d == null) {
			throw new RuntimeException("Discussion avec id= " + id + " introuvable!");
		} else
			return d;
	}

<<<<<<< HEAD
	
=======

	@Override
	public Discussion addMessages(Long id, Message msg) {
		Optional<Discussion> discuss = discussRepo.findById(id);
		if (discuss.isPresent()) {
			Discussion d = discuss.get();
			d.getMsgDiscussions().add(msg);
			return discussRepo.save(d);
		} else {
			throw new ElementNotFoundException(Intervention.class, id);
		}
		
	}
>>>>>>> refs/remotes/origin/master

}
