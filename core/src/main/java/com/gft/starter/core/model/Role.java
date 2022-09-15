package com.gft.starter.core.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

//Declaração de entidade e nome da tabela do banco de dados
@Entity
@Table(name = "tb_role")
public class Role {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuidPerson", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID uuidRole;

	private String role;

	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}

	public UUID getUuidPerson() {
		return uuidRole;
	}

	public void setUuidPerson(UUID uuidRole) {
		this.uuidRole = uuidRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return this.role;
	}
}
