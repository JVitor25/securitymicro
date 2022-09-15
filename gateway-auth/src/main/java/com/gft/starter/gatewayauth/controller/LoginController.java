package com.gft.starter.gatewayauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.starter.core.model.JwtToken;
import com.gft.starter.core.model.Usuario;
import com.gft.starter.gatewayauth.service.UserDetailsServiceImpl;
import com.gft.starter.gatewayauth.utility.JwtUtility;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@PostMapping("/login")
	public JwtToken authenticate(@RequestBody Usuario jwtRequest) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						jwtRequest.getUsername()
						, jwtRequest.getPassword())
				);
		}catch(BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final UserDetails userDetails
			= userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		
		final String token =
				jwtUtility.generateToken(userDetails);
		
		return new JwtToken("Bearer "+token);
		 
	}
	
	
}
