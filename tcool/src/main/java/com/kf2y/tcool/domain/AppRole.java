package com.kf2y.tcool.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Role")
public class AppRole {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String role;

	public AppRole() {
	}

}
