package com.kf2y.tcool.security;

import java.io.Serializable;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// the token
	private String token;
	
	// current user connected
	private UserDetails currentUser;

}
