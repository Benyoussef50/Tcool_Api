package com.kf2y.tcool.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Artisan extends AbstractAuditingEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArtisan;
	
	private String lastName;
	
	private String firstName;
	
	private String domaine;
	
	private String telephone;
	
	private String adresse;
	
	private double note;
	
	@OneToMany()
	private List<Note> myNotes;
	
	
	public Artisan() {
		
	}

}
