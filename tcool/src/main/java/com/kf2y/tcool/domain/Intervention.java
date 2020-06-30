package com.kf2y.tcool.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Intervention extends AbstractAuditingEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIntervention;

	private String title;

	private String details;

	private String status;

	private byte[] audio;

	private byte[] images;

	private String location;

	@JsonIgnore
	@OneToMany()
	private List<Message> msgInterventions;
	public Intervention() {
	}
}
