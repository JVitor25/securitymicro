package com.gft.starter.core.model;

import java.util.UUID;

public class PersonLogin {

	private UUID uuidPerson;

	private String loginPerson;

	private String passwordPerson;

	private String tokenPerson;
	
	private String role;

	public PersonLogin(UUID uuidPerson, String loginPerson, String passwordPerson, String tokenPerson, String role) {
		this.uuidPerson = uuidPerson;
		this.loginPerson = loginPerson;
		this.passwordPerson = passwordPerson;
		this.tokenPerson = tokenPerson;
		this.role = role;
	}

	public PersonLogin() {
	}

	public UUID getUuidPerson() {
		return uuidPerson;
	}

	public void setUuidPerson(UUID uuidPerson) {
		this.uuidPerson = uuidPerson;
	}

	public String getLoginPerson() {
		return loginPerson;
	}

	public void setLoginPerson(String loginPerson) {
		this.loginPerson = loginPerson;
	}

	public String getPasswordPerson() {
		return passwordPerson;
	}

	public void setPasswordPerson(String passwordPerson) {
		this.passwordPerson = passwordPerson;
	}

	public String getTokenPerson() {
		return tokenPerson;
	}

	public void setTokenPerson(String tokenPerson) {
		this.tokenPerson = tokenPerson;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
