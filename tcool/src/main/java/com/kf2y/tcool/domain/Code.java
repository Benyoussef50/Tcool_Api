package com.kf2y.tcool.domain;


import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Code {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCode;

	private String content;
	
	private String status;
	
	private Compte compte;
	
	
	


	public Code() {
		
		Random rnd = new Random();
   	 int number = rnd.nextInt(999999);

       //this.token = UUID.randomUUID().toString();
   	 this.content = String.format("%06d", number);
       this.status = "FREE";
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCompte")
    public Compte getCompte() {
        return compte;
    }

}
