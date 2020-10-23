package com.kf2y.tcool.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Communication extends AbstractAuditingEntity {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommunication;
	
	private String title;

	private String details;
	
	
	@Lob
	private byte[] attachment;
	
	
	@ManyToOne()
	private Copropriete copropriete;
	
	public Communication() {
	}

}
