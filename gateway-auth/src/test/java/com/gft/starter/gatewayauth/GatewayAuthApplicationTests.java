package com.gft.starter.gatewayauth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gft.starter.core.model.Usuario;
import com.gft.starter.core.repository.UsuarioRepository;

@SpringBootTest
class GatewayAuthApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	void criando() {
	Usuario user = new Usuario("admin","admin"); 
		usuarioRepository.save(user);
	}

}
