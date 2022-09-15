package com.gft.starter.gatewayauth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gft.starter.gatewayauth.filter.JwtFilter;
import com.gft.starter.gatewayauth.service.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsServiceImpl);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		
		http.authorizeRequests().antMatchers("/auth/login").permitAll()
			.anyRequest().authenticated()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	}

}