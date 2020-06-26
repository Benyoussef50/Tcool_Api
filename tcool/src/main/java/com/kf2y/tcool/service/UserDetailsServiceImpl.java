package com.kf2y.tcool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.repository.CompteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Compte user = compteRepository.findByEmail(username);
		if(user==null) throw new UsernameNotFoundException("User not found with username: "+ username);
		
		return UserDetailsImpl.build(user);
	}
}
