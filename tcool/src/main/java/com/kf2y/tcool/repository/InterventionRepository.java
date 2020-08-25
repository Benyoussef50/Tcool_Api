package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kf2y.tcool.domain.Intervention;

public interface InterventionRepository extends JpaRepository<Intervention, Long>{
	
	public List<Intervention> findByStatus(String status);
	
	@Query(value="SELECT i.* from `INTERVENTION` i "
			+ "where i.CREATED_BY = :createdBy and i.STATUS = :status ORDER BY CREATED_DATE"
			, nativeQuery = true)
	public List<Intervention> findAllCreatedBy(@Param("createdBy") String createdBy, @Param("status") String status);
	
	@Query(value="SELECT i.* from `INTERVENTION` i "
			+ "where i.CREATED_BY = :createdBy " 
			+ "and i.STATUS not in ('CLOTUREE', 'ANNULEE') ORDER BY CREATED_DATE "
			, nativeQuery = true)
	public List<Intervention> findAllInProgressCreatedByMe(@Param("createdBy") String createdBy);
}
