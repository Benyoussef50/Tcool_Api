package com.kf2y.tcool.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kf2y.tcool.service.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String headerAuth = request.getHeader("Authorization");
	
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
			String authToken = headerAuth.substring(7);
			String username = getUsername(authToken);
			
			log.debug("Checking authentication for user '{}'", username);
			
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				log.debug("Security context was null, so authorizationg user");
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				
				if(jwtTokenUtil.validateToken(authToken, userDetails)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
							null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					log.info("Authorized user '{}', setting security context", username);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		 
		} else {
		
		log.warn("Couldn't find bearer string, will ignore the header");
		}
		filterChain.doFilter(request, response);
	}
	
	private String getUsername( String authToken) {
		try {
			return jwtTokenUtil.getUsernameFromToken(authToken);
		} catch (IllegalArgumentException e) {
			log.error("An error occured during getting username from token", e);
		} catch(ExpiredJwtException e) {
			log.warn("The token is expired and not valid anymore", e);
		}
		return null;
	}

}
