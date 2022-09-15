package com.gft.starter.core.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.starter.core.model.Role;

public interface RoleRepository extends JpaRepository<Role, UUID>{
	
}