package com.kf2y.tcool.web;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.domain.Notification;
import com.kf2y.tcool.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

	@Autowired
	private NotificationService notifService;
	
	@PostMapping("/save-notification")
	public Notification saveNotif(@RequestBody Notification notif) {
		return notifService.save(notif);
	}
	
	@PutMapping("/update/{id}")
	@Transactional
	public Notification updateNotif(@PathVariable Long id) {
		return notifService.update(id);
	} 
	
	@GetMapping("/{id}")
	public Notification getNotificationById(@PathVariable Long id) {
		return notifService.getById(id);
	}
	
	@GetMapping("/unread-notifications")
	public List<Notification> getAllUnreadNotif(){
		return notifService.getAllUnreadNotifs();	
	}
}
