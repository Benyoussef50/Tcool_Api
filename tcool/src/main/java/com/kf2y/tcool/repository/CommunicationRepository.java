package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kf2y.tcool.domain.Communication;
import com.kf2y.tcool.domain.Compte;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, Long> {
	
	@Query(value="SELECT * from `COMMUNICATION` c "
			+ "where c.CREATED_BY = :createdBy " 
			+ "ORDER BY CREATED_DATE "
			, nativeQuery = true)
	List<Communication> findAllCreatedBy(String createdBy);
	
	
	@Query(value="SELECT DISTINCT co.* FROM Communication co, `COPROPRIETE` cp "
			/*+ "INNER JOIN cp.listResidents rs WHERE rs.idCompte = :id"*/
			+ "WHERE co.COPROPRIETE_ID_COPROPRIETE = cp.ID_COPROPRIETE"
			+ " AND cp.ID_COPROPRIETE = :id "
			, nativeQuery = true)
	List<Communication> findByCopropriete(Long id);

}
