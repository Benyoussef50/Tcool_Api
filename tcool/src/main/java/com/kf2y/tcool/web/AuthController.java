package com.kf2y.tcool.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.security.JwtAuthenticationRequest;
import com.kf2y.tcool.security.JwtAuthenticationResponse;
import com.kf2y.tcool.security.JwtTokenUtil;
import com.kf2y.tcool.service.UserDetailsImpl;
import com.kf2y.tcool.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtils;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@PostMapping(value="/login")
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtAuthenticationRequest authRequest) {
		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		String jwtToken = jwtTokenUtils.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtAuthenticationResponse(
				jwtToken, userDetails));
	}
	
	// rafraîchir le token
	@GetMapping("/refresh")
	public ResponseEntity<?> refreshAndGetAuthToken(final HttpServletRequest req){
		String authToken = req.getHeader("Authorization");
		String token = authToken.substring(7);
		String username = jwtTokenUtils.getUsernameFromToken(token);
		UserDetailsImpl user = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
		
		if(jwtTokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			String refreshToken = jwtTokenUtils.refreshToken(token);
			return ResponseEntity.ok(new JwtAuthenticationResponse(
					refreshToken, user));
		} else {
			return null;
		}
	}

}
