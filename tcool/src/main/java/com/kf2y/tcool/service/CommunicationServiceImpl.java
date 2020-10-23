package com.kf2y.tcool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kf2y.tcool.domain.Communication;
import com.kf2y.tcool.domain.Discussion;
import com.kf2y.tcool.repository.CommunicationRepository;

@Service
@Transactional
public class CommunicationServiceImpl implements CommunicationService {
	
	@Autowired
	private CommunicationRepository comRepo;

	@Override
	public Communication save(Communication com) {
		// TODO Auto-generated method stub
		return comRepo.save(com);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		comRepo.deleteById(id);
	}
	
	@Override
	public List<Communication> getAllCommunications() {
		// TODO Auto-generated method stub
		return comRepo.findAll();
	}

	@Override
	public Communication getById(Long id) {
		// TODO Auto-generated method stub
		Communication com = comRepo.findById(id).orElse(null);
		if(com == null) {
			throw new RuntimeException("Communication avec id= "+id+" introuvable!");
		}  else return com;
	}
	
	@Override
	public List<Communication> getOwnerCommunication(String createdBy) {
		// TODO Auto-generated method stub
		return comRepo.findAllCreatedBy(createdBy);
	}

	@Override
	public List<Communication> getCommunicationByCopropriete(Long id) {
		// TODO Auto-generated method stub
		return comRepo.findByCopropriete(id);
	}

}
