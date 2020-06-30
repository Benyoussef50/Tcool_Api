package com.kf2y.tcool.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.domain.Discussion;
import com.kf2y.tcool.service.DiscussionServiceImpl;

@RestController
@RequestMapping("api/discussions")
public class DiscussionController {
	
	@Autowired
	private DiscussionServiceImpl discussService;
	
	
	/************************ Get a discuss **************************/
	@GetMapping("/{id}")
	public Discussion getDiscuss(@PathVariable Long id) {
		return discussService.getById(id);
	}
	
	/********************** Save a discussion **********************/
	@PostMapping("/save-discussion")
	public Discussion saveDiscuss(@RequestBody Discussion discuss) {
		return discussService.save(discuss);
	}
	
	/*********************** Delete discussion ********************/
	@DeleteMapping("/delete/{id}")
	@Transactional
	public void deleteDiscuss(@PathVariable Long id) {
		discussService.delete(id);
	}
	
	/************************* Get all discussions ********************/
	@GetMapping("/all")
	public List<Discussion> getAll(){
		return discussService.getAllDiscussions();
	}
	
	/************************* Get all discussions in progress ********************/
	@GetMapping("/in-progress")
	public List<Discussion> getAllEnCours(){
		return discussService.getDiscussionEnCours();
	}
	
	/************************* Get all discussions closed ********************/
	@GetMapping("/closed")
	public List<Discussion> getAllClosed(){
		return discussService.getDiscussionCloturees();
	}

	/************************* Get all discussions rejetec************************/
	@GetMapping("/rejected")
	public List<Discussion> getAllRejected(){
		return discussService.getDiscussionRejetees();
	}
}
