package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kf2y.tcool.domain.Evenement;


public interface EvenementRepository extends JpaRepository<Evenement, Long>{
	public List<Evenement> findByStatus(String status); 
	
	@Query(value="SELECT e.* from `EVENEMENT` e "
			+ "where e.CREATED_BY = :createdBy and e.STATUS = :status ORDER BY CREATED_DATE"
			, nativeQuery = true)
	public List<Evenement> findAllCreatedBy(@Param("createdBy") String createdBy, @Param("status") String status);
	
	@Query(value="SELECT e.* from `EVENEMENT` e "
			+ "where e.CREATED_BY = :createdBy " 
			+ "and e.STATUS not in ('CLOTUREE', 'REJETEE') ORDER BY CREATED_DATE "
			, nativeQuery = true)
	public List<Evenement> findAllInProgressCreatedByMe(@Param("createdBy") String createdBy);
}
