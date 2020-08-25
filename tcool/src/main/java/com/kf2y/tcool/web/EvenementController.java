package com.kf2y.tcool.web;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.domain.Evenement;
import com.kf2y.tcool.domain.Message;
import com.kf2y.tcool.service.EvenementServiceImpl;

@RestController
@RequestMapping("api/evenements")
public class EvenementController {
	@Autowired
	private EvenementServiceImpl event;
	
	@PostMapping("/save-evenement")
	public Evenement saveEvent(@RequestBody Evenement evenement) {
		return event.save(evenement);
	}
	
	@DeleteMapping("/delete/{id}")
	@Transactional
	public void deleteEvent(@PathVariable Long id) {
		 event.remove(id);
	}
	
	@GetMapping("/all")
	public List<Evenement> getAll(){
		return event.findAllEvents();
	}
	
	@GetMapping("/owned-by/{createdBy}/{status}")
	public List<Evenement> getEventsOwnedBy(@PathVariable String createdBy, @PathVariable String status) {
		return event.getOwnerEvents(createdBy, status);
	}
	
	@GetMapping("/in-progress/owned-by/{createdBy}")
	public List<Evenement> getDiscussionsInProgressOwnedBy(@PathVariable String createdBy) {
		return event.getOwnerEventsInProgress(createdBy);
	}
	
	@GetMapping("/encours")
	public List<Evenement> getAllEnCours(){
		return event.findEventsEnCours();
	}
	
	@GetMapping("/cloturees")
	public List<Evenement> getAllCloturees(){
		return event.findEventsCloturees();
	}
	
	@GetMapping("/annulees")
	public List<Evenement> getAllAnnulees(){
		return event.findEventsRejetees();
	}
	
	@GetMapping("/{id}")
	public Evenement getById(@PathVariable Long id) {
		return event.findEvenementById(id);
	}
	
	@PutMapping("/rejeter-status/{id}")
	@Transactional
	public Evenement annulerStatus(@PathVariable Long id) {
		return event.update("REJETEE", id);
	}
	
	@PutMapping("/cloturer-status/{id}")
	@Transactional
	public Evenement cloturerStatus(@PathVariable Long id) {
		return event.update("CLOTUREE", id);
	}
	
	@PutMapping("/add-message/{id}")
	@Transactional
	public Evenement addMessage(@PathVariable Long id, @RequestBody Message msg) {
		return event.addMessages(id, msg);
	}
	
	

}
