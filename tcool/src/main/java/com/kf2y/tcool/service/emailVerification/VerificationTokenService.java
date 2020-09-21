package com.kf2y.tcool.service.emailVerification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.domain.VerificationToken;
import com.kf2y.tcool.repository.CompteRepository;
import com.kf2y.tcool.repository.VerificationTokenRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VerificationTokenService {
    private CompteRepository compteRepository;
    private VerificationTokenRepository verificationTokenRepository;
    private SendingMailService sendingMailService;

    @Autowired
    public VerificationTokenService(CompteRepository compteRepository, VerificationTokenRepository verificationTokenRepository, SendingMailService sendingMailService){
        this.compteRepository = compteRepository;
        this.verificationTokenRepository = verificationTokenRepository;
        this.sendingMailService = sendingMailService;
    }

    public void createVerification(Compte c ){
        Compte v_compte = compteRepository.findByEmail(c.getEmail());
        Compte compte;
        if (v_compte==null) {
            compte = new Compte();
            compte.setEmail(c.getEmail());
            compteRepository.save(compte);
        } else {
            compte = v_compte; //comptes.get(0);
        }

        List<VerificationToken> verificationTokens = verificationTokenRepository.findByCompteEmail(c.getEmail());
        VerificationToken verificationToken;
        if (verificationTokens.isEmpty()) {
            verificationToken = new VerificationToken();
            verificationToken.setCompte(compte);
            verificationTokenRepository.save(verificationToken);
        } else {
            verificationToken = verificationTokens.get(0);
        }

        sendingMailService.sendVerificationMail(c, verificationToken.getToken());
    }

    public Compte verifyEmail(String token){
        List<VerificationToken> verificationTokens = verificationTokenRepository.findByToken(token);
        if (verificationTokens.isEmpty()) {
            return null;//ResponseEntity.badRequest().body("Invalid token.") ;
        }

        VerificationToken verificationToken = verificationTokens.get(0);
        if (verificationToken.getExpiredDateTime().isBefore(LocalDateTime.now())) {
            return null;//return ResponseEntity.unprocessableEntity().body("Expired token.");
        }

        verificationToken.setConfirmedDateTime(LocalDateTime.now());
        verificationToken.setStatus(VerificationToken.STATUS_VERIFIED);
        verificationToken.getCompte().setIsActive(true);
        verificationTokenRepository.save(verificationToken);

        //return ResponseEntity.ok("You have successfully verified your email address.");
        return verificationToken.getCompte();
    }
}
