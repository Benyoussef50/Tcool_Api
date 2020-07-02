package com.kf2y.tcool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.domain.Message;
import com.kf2y.tcool.service.MessageServiceImpl;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

	@Autowired
	private MessageServiceImpl msgService;
	
	@PostMapping("/save-message")
	public Message saveMessage(@RequestBody Message message) {
		return msgService.save(message);
	}
	
	@DeleteMapping("/delete/{id}")
	@Transactional
	public void deleteMessage(@PathVariable Long id) {
		msgService.delete(id);
	}
}
