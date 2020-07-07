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

import com.kf2y.tcool.domain.Copropriete;
import com.kf2y.tcool.exception.ResourceNotFoundException;
import com.kf2y.tcool.service.CoproprieteServiceImpl;

@RestController
@RequestMapping("/api/coproprietes")
public class CoproprieteController {

	@Autowired
	private CoproprieteServiceImpl copropServ;
	
	@GetMapping("/{id}")
	public Copropriete getCopropriete(@PathVariable Long id) {
		return copropServ.getById(id);
	}
	
	@GetMapping("/all")
	public List<Copropriete> getAllCoproprites(){
		return copropServ.getAllCopropriete();
	}
	
	@Transactional
	@DeleteMapping("/delete/{id}")
	public void deleteCoproprite(@PathVariable Long id) {
		copropServ.delete(id);
	}
	
	@PostMapping("/save-copropriete")
	public Copropriete saveCopropriete(@RequestBody Copropriete cop) {
		return copropServ.save(cop);
	}
	
	@PutMapping("/update/{id}")
	public Copropriete updateCopriete(@PathVariable Long id, @RequestBody Copropriete cop) 
		throws ResourceNotFoundException {
		Copropriete newCop = copropServ.getById(cop.getIdCopropriete());
		if (newCop == null) throw new ResourceNotFoundException("Co-ownership not found on :: " + id);
		newCop = cop;
		
		return copropServ.save(newCop);
	}
}
