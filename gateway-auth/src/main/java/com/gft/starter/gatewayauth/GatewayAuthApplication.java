package com.gft.starter.gatewayauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.gft.starter.core.model"})
@EnableJpaRepositories({"com.gft.starter.core.repository"})
public class GatewayAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayAuthApplication.class, args);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
