package com.kf2y.tcool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kf2y.tcool.domain.AppRole;





public interface AppRoleRepository extends JpaRepository<AppRole, Long>{
	Optional<AppRole> findByRole(String role);
}
