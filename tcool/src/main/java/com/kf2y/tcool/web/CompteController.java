package com.kf2y.tcool.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.domain.Notification;
import com.kf2y.tcool.exception.ResourceNotFoundException;
import com.kf2y.tcool.service.CompteServiceImpl;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {
	
	@Autowired
	private CompteServiceImpl compteService;
	
	@Autowired
	PasswordEncoder encoder;
	
	// get an account by its id
	@GetMapping("/{id}")
	public Compte getCompte(@PathVariable Long id) {
		return compteService.getById(id);
	}
	 // get unread notifications
	@GetMapping("/notif-no-read/{id}")
	public List<Notification> getNoReadNotifs(@PathVariable Long id){
		return compteService.getNoReadNotif(id);
	}
	
	@GetMapping("notif-no-read-cpt/{id}")
	public Compte getNoReadNotifsR(@PathVariable Long id){
		return compteService.getNoReadNotifcpt(id);
	}
	
	// save an account
	@PostMapping("/save-account")
	public Compte saveCompte(@RequestBody Compte compte) {
		compte.setPassword(encoder.encode(compte.getPassword()));
		return compteService.save(compte);
	}
	
	// update an account
	@PutMapping("/update/{id}")
	@Transactional
	public Compte updateCompte(@PathVariable Long id ,@RequestBody Compte compte) 
		throws ResourceNotFoundException {
		Compte c = compteService.getById(compte.getIdCompte());
		if(c == null) throw new ResourceNotFoundException("Account not found on :: "+ compte.getIdCompte());
		c.setFirstName(compte.getFirstName());
		c.setLastName(compte.getLastName());
		c.setPhone(compte.getPhone());
		c.setPassword(encoder.encode(compte.getPassword()));
		c.setEmail(compte.getEmail());
		c.setMyRole(compte.getMyRole());
		c.setAvatar(compte.getAvatar());
		
		return compteService.save(c);
	}
	
	// delete an account
	@Transactional
	@DeleteMapping("/delete/{id}")
	public void deleteCompte(@PathVariable Long id) {
		compteService.delete(id);
	}

	// get all account
	@GetMapping("/all")
	public List<Compte> getAll(){
		return compteService.getAllCompte();
	}
	

	// get all intervenants
	@GetMapping("/intervenants")
	public List<Compte> getAllIntervenants() {
		return compteService.getAllIntervenants();
	}
	
	// get all syndics
	@GetMapping("/syndics")
	public List<Compte> getAllSyndics() {
		return compteService.getAllSyndics();
	}
	
	// Notifier tous les syndics
	@PostMapping("/notif-syndic")
	public List<Compte> addNotifSyndic(@RequestBody Notification notification){
		return compteService.addNotifsToSyndic(notification);
	}
	
	// Notifier tous les intervenants
	@PostMapping("/notif-intervenant")
	public List<Compte> addNotifInter(@RequestBody Notification notification){
		return compteService.addNotifsToInter(notification);
	}
	
	// Notifier un Acteur par son Id
	@PostMapping("/notif-acteur/{id}")
	public Compte addNotifActeur(@RequestBody Notification notification,@PathVariable Long id){
		return compteService.notifierActeur(notification, id);
	}
	
	// Notifier un Acteur par son email
	@PostMapping("/notif-acteur-by-email/{email}")
	public Compte addNotifActeur(@RequestBody Notification notification,@PathVariable String email){
		return compteService.notifierActeurByEmail(notification, email);
	}
	
	// Notifier tous les residents
	@PostMapping("/notif-resident")
	public List<Compte> addNotif(@RequestBody Notification notification){
		return compteService.addNotifsToResid(notification);
	}
}
