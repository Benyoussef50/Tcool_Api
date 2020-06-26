package com.kf2y.tcool.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kf2y.tcool.domain.Compte;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	// username will be the email
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private Date lastPasswordResetDate;

	
	public UserDetailsImpl(Long id, String username, String password,
			Date lastPasswordResetDate,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.lastPasswordResetDate = lastPasswordResetDate;
	}
	
	
	public static UserDetailsImpl build(Compte compte) {
		List<GrantedAuthority> authorities = compte.getMyRole().stream()
			.map(role -> new SimpleGrantedAuthority(role.getRole()))
			.collect(Collectors.toList());
		
		return new UserDetailsImpl(
				compte.getIdCompte(),
				compte.getEmail(), // l'email sert de username
				compte.getPassword(),
				compte.getLastModifiedDate(),
				authorities);
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
