package com.kf2y.tcool.domain;

import java.sql.Date;
import java.time.LocalTime;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Evenement extends AbstractAuditingEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvenement;

	private String title;

	private String details;

	private String visibility;

	private String status;
	
	private LocalTime duration;
	
	//date event add 
	private Date eventDate;
	
	//@Lob
	//document add  
	//private byte[] document;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<EvenementDocs> documents;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Message> msgEvents;

	public Evenement() {
	}

}
