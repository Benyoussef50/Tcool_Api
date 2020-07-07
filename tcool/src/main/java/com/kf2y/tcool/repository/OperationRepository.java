package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kf2y.tcool.domain.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{

	public List<Operation> findByType(String type);
}
