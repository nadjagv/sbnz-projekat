package sbnz.integracija.example.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.JwtAuthenticationRequest;
import sbnz.integracija.example.dto.UserTokenState;
import sbnz.integracija.example.facts.User;
import sbnz.integracija.example.util.TokenUtils;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<Object> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {
		

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		User user = (User) authentication.getPrincipal();
		
		String jwt = tokenUtils.generateToken(user);
		Long expiresIn = (long) tokenUtils.getExpiredIn();

		return new ResponseEntity<>(new UserTokenState(jwt, user.getUsername(), user.getRoles().get(0).getRole(), expiresIn),HttpStatus.OK);
	}

}
