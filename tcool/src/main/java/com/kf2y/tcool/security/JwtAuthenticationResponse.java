package com.kf2y.tcool.security;

import java.io.Serializable;

import com.kf2y.tcool.service.UserDetailsImpl;

import lombok.Data;

@Data
public class JwtAuthenticationResponse implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// the token
	private String token;
	
	// current user connected
	private UserDetailsImpl currentUser;

}
