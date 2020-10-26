package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kf2y.tcool.domain.Code;
import com.kf2y.tcool.domain.VerificationToken;


public interface CodeRepository extends JpaRepository<Code, Long> {
	
	//List<Code> findByCompteEmail(String email);
	
	@Query(value="SELECT * from Code c "
			+ "where c.content =:content"
			+ " AND c.status = 'FREE' " 
			, nativeQuery = true)
	Code findByCode(String content);
}
