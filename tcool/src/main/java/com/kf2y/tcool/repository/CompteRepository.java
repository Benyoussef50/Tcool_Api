package com.kf2y.tcool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kf2y.tcool.domain.Compte;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

	public Compte findByEmail(String email);
	public Boolean existsByEmail(String email);
   

	@Query(value="SELECT c.* from `COMPTE` c INNER JOIN `COMPTE_MY_ROLE` cr"
			+ " ON c.ID_COMPTE = cr.COMPTE_ID_COMPTE "
			+ "where cr.MY_ROLE_ID =3"
			, nativeQuery = true)
	public List<Compte> findAllIdInter();

	@Query(value="SELECT c.* from `COMPTE` c INNER JOIN `COMPTE_MY_ROLE` cr"
			+ " ON c.ID_COMPTE = cr.COMPTE_ID_COMPTE "
			+ "where cr.MY_ROLE_ID =2"
			, nativeQuery = true)
	public List<Compte> findAllGestion();
	
	@Query(value="SELECT c.* from `COMPTE` c INNER JOIN `COMPTE_MY_ROLE` cr"
			+ " ON c.ID_COMPTE = cr.COMPTE_ID_COMPTE "
			+ "where cr.MY_ROLE_ID =1"
			, nativeQuery = true)
	public List<Compte> findAllResid();
}
