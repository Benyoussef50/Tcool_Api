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

import com.kf2y.tcool.domain.Intervention;
import com.kf2y.tcool.service.InterventionServiceImpl;

@RestController
@RequestMapping("api/interventions")
public class InterventionController {

	@Autowired
	private InterventionServiceImpl impl;

	@PostMapping("/save-intervention")
	public Intervention saveInter(@RequestBody Intervention intervention) {
		return impl.save(intervention);
	}
	

	@DeleteMapping("/delete/{id}")
	@Transactional
	public void deleteInter(@PathVariable Long id) {
		impl.remove(id);
	}

	@GetMapping("/all")
	public List<Intervention> getAll() {
		return impl.findAllIntervention();
	}
	
	@GetMapping("/encours")
	public List<Intervention> getAllEnCours(){
		return impl.findInterEnCours();
	}
	
	@GetMapping("/cloturees")
	public List<Intervention> getAllCloturees(){
		return impl.findInterCloturees();
	}
	
	@GetMapping("/annulees")
	public List<Intervention> getAllAnnulees(){
		return impl.findInterAnnulees();
	}
	
	@GetMapping("/{id}")
	public Intervention getById(@PathVariable Long id) {
		return impl.findInterventionById(id);
	}
	
	@PutMapping("/annuler-status")
	@Transactional
	public Intervention annulerStatus(@RequestBody Intervention body) {
		 return impl.update("ANNULEE", body);
	}
	
	@PutMapping("/cloturer-status")
	@Transactional
	public Intervention cloturerStatus(@RequestBody Intervention body) {
		return impl.update("CLOTUREE", body);
	}
}
