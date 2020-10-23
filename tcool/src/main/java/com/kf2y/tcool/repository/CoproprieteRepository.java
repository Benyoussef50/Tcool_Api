package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.domain.Copropriete;

public interface CoproprieteRepository extends JpaRepository<Copropriete, Long> {

	
	@Query(value = "SELECT DISTINCT cp FROM Copropriete cp INNER JOIN cp.listResidents rs  WHERE rs.idCompte = ?1")
	public List<Copropriete> findAllCopByCompte(final Long id);
	
}
