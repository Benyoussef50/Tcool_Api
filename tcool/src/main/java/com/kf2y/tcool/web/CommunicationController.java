package com.kf2y.tcool.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.domain.Communication;
import com.kf2y.tcool.domain.Discussion;
import com.kf2y.tcool.exception.ResourceNotFoundException;
import com.kf2y.tcool.service.CommunicationServiceImpl;

@RestController
@RequestMapping("/api/communications")
public class CommunicationController {
	
	@Autowired
	private CommunicationServiceImpl comServ;
	
	@GetMapping("/{id}")
	public Communication getCommunication(@PathVariable Long id) {
		return  comServ.getById(id);
	}
	
	@GetMapping("/all")
	public List<Communication> getAllCommunications(){
		return comServ.getAllCommunications();
	}
	
	@GetMapping("/all/{id}")
	public List<Communication> getAllCopCommunications(@PathVariable Long id){
		return comServ.getCommunicationByCopropriete(id);
		//return comServ.getAllCommunications();
	}
	
	@Transactional
	@DeleteMapping("/delete/{id}")
	public void deleteCommunication(@PathVariable Long id) {
		comServ.delete(id);
	}
	
	@PostMapping("/save-communication")
	public Communication saveCommunication(@RequestBody Communication com) {
		return comServ.save(com);
	}
	
	@PutMapping("/update/{id}")
	public Communication updateCommunication(@PathVariable Long id, @RequestBody Communication com) 
		throws ResourceNotFoundException {
		Communication newCom = comServ.getById(com.getIdCommunication());
		if (newCom == null) throw new ResourceNotFoundException("update successfuly " + id);
		newCom = com;
		
		return comServ.save(newCom);
	}
	
	/********************* get communications by createdBy attribute *********************/
	@GetMapping("/owned-by/{createdBy}")
	public List<Communication> getCommunicationsOwnBy(@PathVariable String createdBy) {
		return comServ.getOwnerCommunication(createdBy);
	}

}
