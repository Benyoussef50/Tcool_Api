package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Notification;

public interface NotificationService {

	public Notification getById(Long id);
	public Notification save(Notification notif);
	public Notification update(Long id);
	public List<Notification> getAllUnreadNotifs();
}
