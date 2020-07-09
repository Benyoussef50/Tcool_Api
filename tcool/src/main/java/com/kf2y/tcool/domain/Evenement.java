package com.kf2y.tcool.domain;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<EvenementDocs> documents;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Message> msgEvents;

	public Evenement() {
	}

}
