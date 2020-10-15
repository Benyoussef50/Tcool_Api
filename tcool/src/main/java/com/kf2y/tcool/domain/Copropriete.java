package com.kf2y.tcool.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	@ManyToOne()
	private Compte gestionnaire;

	private int nbResidents;

	private String city;
	
	// permet d'avoir une trace sur les résidents de la coproprieté
	@OneToMany()
	private List<Compte> listResidents;

	public Copropriete() {
	}

}
