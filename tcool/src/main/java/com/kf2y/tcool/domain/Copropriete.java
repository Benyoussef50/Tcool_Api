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
public class Copropriete extends AbstractAuditingEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCopropriete;

	private String name;

	private String details;

	private Compte syndic;

	private int nbResidents;

	private String city;

	public Copropriete() {
	}

}
