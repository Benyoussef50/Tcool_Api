package com.kf2y.tcool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kf2y.tcool.domain.Notification;
import com.kf2y.tcool.repository.NotificationRepository;
import com.kf2y.tcool.service.exception.ElementNotFoundException;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationRepository notifRepo;

	@Override
	public Notification save(Notification notif) {
		// TODO Auto-generated method stub
		return notifRepo.save(notif);
	}

	@Transactional
	@Override
	public Notification update(Long id) {
		Optional<Notification> temp = notifRepo.findById(id);
		if (temp.isPresent()) {
			Notification notif = temp.get();
			notif.setRead(true);
			return notifRepo.save(notif);
		} else {
			throw new ElementNotFoundException(Notification.class, id);
		}
	}

	@Override
	public List<Notification> getAllUnreadNotifs() {
		// TODO Auto-generated method stub
		return notifRepo.findByIsRead(false);
	}

	@Override
	public Notification getById(Long id) {
		// TODO Auto-generated method stub
		Notification n = notifRepo.findById(id).orElse(null);
		if (n == null) {
			throw new RuntimeException("Notification avec id= " + id + " introuvable!");
		} else
			return n;
	}

	@Transactional
	@Override
	public Notification setReadtoYes(Long id) {
		Optional<Notification> notif = notifRepo.findById(id);
		if(notif.isPresent()) {
			Notification notification = notif.get();
			notification.setRead(true);
			return notifRepo.save(notification);
		} else {
			throw new ElementNotFoundException(Notification.class, id);
		}
	}

}
