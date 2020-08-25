package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kf2y.tcool.domain.Discussion;



public interface DiscussionRepository extends JpaRepository<Discussion, Long>{
	
	public List<Discussion> findByStatus(String status);
	
	@Query(value="SELECT d.* from `DISCUSSION` d "
			+ "where d.CREATED_BY = :createdBy and d.STATUS = :status ORDER BY CREATED_DATE"
			, nativeQuery = true)
	public List<Discussion> findAllCreatedBy(@Param("createdBy") String createdBy, @Param("status") String status);
	
	@Query(value="SELECT d.* from `DISCUSSION` d "
			+ "where d.CREATED_BY = :createdBy " 
			+ "and d.STATUS not in ('CLOTUREE', 'REJETEE') ORDER BY CREATED_DATE "
			, nativeQuery = true)
	public List<Discussion> findAllInProgressCreatedByMe(@Param("createdBy") String createdBy);

}
