package com.kf2y.tcool.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reservation extends AbstractAuditingEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservation;
	private String field;
	private Date day;
	private int startHour;
	private int numberOfPersons;
	private String phoneNumber;
	private String description;
	
}
