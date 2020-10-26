package com.kf2y.tcool.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kf2y.tcool.domain.AppRole;
import com.kf2y.tcool.domain.Code;
import com.kf2y.tcool.domain.Compte;
import com.kf2y.tcool.repository.AppRoleRepository;
import com.kf2y.tcool.repository.CompteRepository;
import com.kf2y.tcool.security.JwtAuthenticationRequest;
import com.kf2y.tcool.security.JwtAuthenticationResponse;
import com.kf2y.tcool.security.JwtTokenUtil;
import com.kf2y.tcool.security.MessageResponse;
import com.kf2y.tcool.security.SignUpRequest;
import com.kf2y.tcool.service.CodeServiceImpl;
import com.kf2y.tcool.service.UserDetailsImpl;
import com.kf2y.tcool.service.UserDetailsServiceImpl;
import com.kf2y.tcool.service.emailVerification.VerificationTokenService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtils;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	CompteRepository compteRepository;

	@Autowired
	AppRoleRepository appRoleRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private CodeServiceImpl codeService;
	
	// email verification 
	  @Autowired
	    VerificationTokenService verificationTokenService;
	  

	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtAuthenticationRequest authRequest) {
		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		String jwtToken = jwtTokenUtils.generateToken(userDetails);

		return ResponseEntity.ok(new JwtAuthenticationResponse(jwtToken, userDetails));
	}

	// rafraîchir le token
	@GetMapping("/refresh")
	public ResponseEntity<?> refreshAndGetAuthToken(final HttpServletRequest req) {
		String authToken = req.getHeader("Authorization");
		String token = authToken.substring(7);
		String username = jwtTokenUtils.getUsernameFromToken(token);
		UserDetailsImpl user = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);

		if (jwtTokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			String refreshToken = jwtTokenUtils.refreshToken(token);
			return ResponseEntity.ok(new JwtAuthenticationResponse(refreshToken, user));
		} else {
			return ResponseEntity.ok("not refreshed");
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> createAccount(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (compteRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Login is already taken!"));
		}

		Compte compte = new Compte(signUpRequest.getCreatedBy(),signUpRequest.getFirstName(), signUpRequest.getLastName(),signUpRequest.getImmeuble(),signUpRequest.getAppartement(), signUpRequest.getEmail(),
				signUpRequest.getPhone(), encoder.encode(signUpRequest.getPassword()));

		String role = signUpRequest.getMyRole();
		List<AppRole> roles = new LinkedList<AppRole>();

		if (role == null) {
			AppRole compteRole = appRoleRepository.findByRole("RESIDENT")
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(compteRole);

		} else {
			switch (role) {
			case "GESTIONNAIRE":
				AppRole gestionnaireRole = appRoleRepository.findByRole("GESTIONNAIRE")
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(gestionnaireRole);
				break;

			case "INTERVENANT":
				AppRole intervenantRole = appRoleRepository.findByRole("INTERVENANT")
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(intervenantRole);
				break;

			default:
				AppRole compteRole = appRoleRepository.findByRole("RESIDENT")
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(compteRole);

			}
		}
		
		compte.setMyRole(roles);
		try {
			compteRepository.save(compte);
			verificationTokenService.createVerification(compte);
		}catch(Exception re) {
			re.printStackTrace();
		}

		return ResponseEntity.ok(new MessageResponse("Compte registered successfully!"));
	}
	
	//--------------------------- system of email verification -------------------------
	

    @PostMapping("/verify-email")
    public ResponseEntity<MessageResponse> verifyEmail(@RequestBody Map<String, Object> payload) {
    	String code = (String) payload.get("code");

    	System.out.println(payload.get("code"));
    	System.out.println("********************");
    	if(code!=null) {
    		System.out.println(code);
    	}
    	else {
    		System.out.println("no code");
    	}
        Compte c = verificationTokenService.verifyEmail(code);
        if(c!=null) {
        return ResponseEntity.ok(new MessageResponse("Compte registered successfully!"));//verificationTokenService.verifyEmail(code).getBody();
        }
        else {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST," code error ");
        }
    }
    
    @PostMapping("/verify-code")
    public ResponseEntity<MessageResponse> verifyCode(@RequestBody Map<String, Object> payload) {
    	String code = (String) payload.get("code");

    	System.out.println(payload.get("code"));
    	System.out.println("********************");
    	if(code!=null) {
    		System.out.println(code);
    	}
    	else {
    		System.out.println("no code");
    	}
        Code c = codeService.getByCode(code);
        if(c!=null) {
        	c.setStatus("USED");
        	codeService.save(c);
        return ResponseEntity.ok(new MessageResponse(c.getContent()));//verificationTokenService.verifyEmail(code).getBody();
        }
        else {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST," code error ");
        }
    }
}
