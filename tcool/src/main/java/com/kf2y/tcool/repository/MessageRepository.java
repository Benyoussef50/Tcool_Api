package com.kf2y.tcool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kf2y.tcool.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
