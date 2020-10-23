package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kf2y.tcool.domain.Code;


public interface CodeRepository extends JpaRepository<Code, Long> {

	
	@Query(value="SELECT * from Code c "
			+ "where c.content =:content" 
			, nativeQuery = true)
	Code findByCode(String content);
}
