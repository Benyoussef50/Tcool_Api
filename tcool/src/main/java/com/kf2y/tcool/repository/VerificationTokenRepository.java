package com.kf2y.tcool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kf2y.tcool.domain.VerificationToken;

import java.util.List;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String> {
    List<VerificationToken> findByCompteEmail(String email);
    List<VerificationToken> findByToken(String token);
}
