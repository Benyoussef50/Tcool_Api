package com.kf2y.tcool.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Compte extends AbstractAuditingEntity {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompte;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private String password;
	
	private Boolean isActive;
	
	
	//verification token
   // private VerificationToken verificationToken;
	
	// mon rôle
	@ManyToMany()
	private List<AppRole> myRole;
	
	// ma liste de discussion
	@OneToMany()
	private List<Discussion> myDiscussions;
	
	// ma liste des évènements
	@OneToMany()
	private List<Evenement> myEvents;
	
	// ma liste des interventions
	@OneToMany()
	private List<Intervention> myInterventions;
	
	// mes opérations
	@OneToMany()
	private List<Operation> myOperations;
	
	// mes notifications
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Notification> myNotifications;
	
	@OneToMany()
	private List<Copropriete> coproprietes;
	

	public Compte() {
	}


	public Compte(String createdBy ,String firstName, String lastName, String email, String phone, String password) {
		super();
		super.setCreatedBy(createdBy);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.isActive =false;
	}
	

}
