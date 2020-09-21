package com.kf2y.tcool.service.emailVerification;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.server.RSocketServer.Transport;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kf2y.tcool.domain.Compte;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class SendingMailService {
    
	
	
//	@Autowired
//	private JavaMailSender mailSender;
	
	@Autowired
    private JavaMailSender mailSender;

    @Autowired
    SendingMailService(){
    }

    public boolean sendVerificationMail(Compte c, String verificationCode) {
        String subject = "Please verify your email";
        String body = "";
        try {
        	
  
            body = "VERIFICATION_Code : " + verificationCode;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return sendMail(c.getEmail(), subject, body);
    }

    private boolean sendMail(String toEmail, String subject, String body) {
         
    	try {
    		   
    		SimpleMailMessage email = new SimpleMailMessage();
    		email.setFrom("kanssougiba1997@gmail.com");
            email.setTo(toEmail);
            email.setSubject(subject);
            email.setText(body);
            System.out.println(body);
            mailSender.send(email);
    		return true;	
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
        
    	return false;

    }
}