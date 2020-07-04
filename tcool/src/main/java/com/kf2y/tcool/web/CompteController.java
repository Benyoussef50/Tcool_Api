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

import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.exception.ResourceNotFoundException;
import com.kf2y.tcool.service.CompteServiceImpl;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {
	
	@Autowired
	private CompteServiceImpl compteService;
	
	// get an account by its id
	@GetMapping("/{id}")
	public Compte getCompte(@PathVariable Long id) {
		return compteService.getById(id);
	}
	
	// save an account
	@PostMapping("/save-account")
	public Compte saveCompte(@RequestBody Compte compte) {
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
		c.setPassword(compte.getPassword());
		c.setEmail(compte.getEmail());
		c.setMyRole(compte.getMyRole());
		
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
}
