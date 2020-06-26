package com.kf2y.tcool.security;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String createdBy;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private String password;
	
    private String myRole;
}
