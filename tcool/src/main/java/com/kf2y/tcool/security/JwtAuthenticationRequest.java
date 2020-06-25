package com.kf2y.tcool.security;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// will be the email
	private String username;
	private String password;
}
