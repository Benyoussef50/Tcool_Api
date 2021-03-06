package com.kf2y.tcool.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.kf2y.tcool.security.JwtAuthenticationEntryPoint;
import com.kf2y.tcool.security.JwtAuthorizationTokenFilter;
import com.kf2y.tcool.service.UserDetailsServiceImpl;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint entryPointHadler;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtAuthorizationTokenFilter jwtAuthFiler;
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.cors().and()
			.exceptionHandling().authenticationEntryPoint(entryPointHadler).and()
			
			// do not create a session
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()
			.antMatchers("/h2-console/**/**").permitAll()
			.antMatchers("/api/auth/**", "/api/interventions/audio/**").permitAll().anyRequest().authenticated();
		
		http.addFilterBefore(jwtAuthFiler, UsernamePasswordAuthenticationFilter.class);
		
		// disable page caching
		http.headers().frameOptions().sameOrigin().cacheControl();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			// allow anonymous resource requests
			.and().ignoring()
			.antMatchers(HttpMethod.GET, "/", "/api/interventions/audio/*", "/resources/**", "/static/**", "/public/**", "/favicon.ico",
					"/**/*.css", "/**/*.js", "/**/*.jpg")
			.and().ignoring().antMatchers("/h2-console/**/**");
	}
	
    @Bean
    @Profile(ConfigConstants.PROFILE_DEVELOPPEMENT)
    CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));

        source.registerCorsConfiguration("/**", configuration);
        return (CorsConfigurationSource) source;
    }
}
