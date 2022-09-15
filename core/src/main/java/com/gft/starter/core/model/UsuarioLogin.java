package com.gft.starter.core.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UsuarioLogin {
	@NotNull
	@Email
	@Length(min = 5, max = 50)
	private String loginPerson;

	@NotNull
	@Length(min = 5, max = 10)
	private String passwordPerson;

	public UsuarioLogin() {
		
	}

	public UsuarioLogin(String loginPerson, String passwordPerson) {
		this.loginPerson = loginPerson;
		this.passwordPerson = passwordPerson;
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

}
