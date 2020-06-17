package com.kf2y.tcool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kf2y.tcool.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
