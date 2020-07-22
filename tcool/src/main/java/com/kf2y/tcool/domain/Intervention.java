package com.kf2y.tcool.domain;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	private String theme;
	
	private String title;

	private String details;

	private String status;
	
	private String audio;
	
	@ManyToOne()
	private Compte intervenant;

	@Lob
	private byte[] images;

	private String location;
	

//	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Message> msgInterventions;
	public Intervention() {
	}
	
	@Override
	public String toString() {
		return "Intervention [idIntervention=" + idIntervention + ", title=" + title + ", details=" + details
				+ ", status=" + status + ", audio=" + audio + ", intervenant=" + intervenant.toString()+ ", images=" + Arrays.toString(images)
				+ ", location=" + location + ", msgInterventions=" + msgInterventions + "]";
	}
}
