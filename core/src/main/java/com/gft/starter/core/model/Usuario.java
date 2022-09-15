package com.gft.starter.core.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

//MappedSuperclass informa ao programa que esta classe se trata de um superclass e que a função dela é só atribuir
//Inheritance informa como vai funcionar a herança
//Usando o joined, fará a tabela de pessoa e as outras vinculadas
@Entity
@DiscriminatorColumn(name = "TYPE")
@Table(name = "tb_usuario")
public class Usuario {

	// Gerador UUID
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuidPerson", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID uuidPerson;

	private String username;
	
	private String password;

	public Usuario(UUID uuidPerson, String username, String password) {
		this.uuidPerson = uuidPerson;
		this.username = username;
		this.password = password;
	}
	
	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Usuario() {}

	public UUID getUuidPerson() {
		return uuidPerson;
	}

	public void setUuidPerson(UUID uuidPerson) {
		this.uuidPerson = uuidPerson;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
