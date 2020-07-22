package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kf2y.tcool.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
	public List<Notification> findByIsRead(boolean isRead);
}
