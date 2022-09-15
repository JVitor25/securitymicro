package com.gft.starter.gatewayauth.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gft.starter.core.model.Usuario;
import com.gft.starter.core.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<Usuario> user = userRepository.findByUsername(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
		
		return new User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
	}
}

