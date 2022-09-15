package com.gft.starter.core.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.starter.core.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

	public Optional<Usuario> findByUsername(String Username);
}
