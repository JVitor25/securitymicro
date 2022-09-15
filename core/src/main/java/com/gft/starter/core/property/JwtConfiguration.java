package com.gft.starter.core.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

import lombok.ToString;

@Configuration
@ConfigurationProperties(prefix="jwt.config")
@ToString
public class JwtConfiguration {
	
	private String login = "/login/**";
	@NestedConfigurationProperty
	private Header header = new Header();
	private int expiration = 3600;
	private String privateKey = "7SGDv4K21TXX2z96BMUWrdtQLvT3uwkk";
	private String type = "encrypted";
	
	
	public static class Header {
		private String name = "Authorization";
		private String prefix = "Bearer ";
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPrefix() {
			return prefix;
		}
		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public int getExpiration() {
		return expiration;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
