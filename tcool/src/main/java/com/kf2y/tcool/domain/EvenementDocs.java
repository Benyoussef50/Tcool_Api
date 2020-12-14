package com.kf2y.tcool.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EvenementDocs extends AbstractAuditingEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEventDoc;
	
	//Modify 11-11-2020
	
	private String name;
	
	private String content;
	
	private String extension;
	
	

	public EvenementDocs() {
	}
}
