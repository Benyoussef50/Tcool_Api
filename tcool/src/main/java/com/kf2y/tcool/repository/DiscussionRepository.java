package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kf2y.tcool.domain.Discussion;



public interface DiscussionRepository extends JpaRepository<Discussion, Long>{
	
	public List<Discussion> findByStatus(String status);

}
