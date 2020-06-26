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
public class Discussion extends AbstractAuditingEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDiscussion;

	private String theme;

	private String title;

	private String details;

	private String visibility;

	private String status;

	private String reference;
	
	@OneToMany()
	private List<Message> msgDiscussions;

	public Discussion() {
	}

}
