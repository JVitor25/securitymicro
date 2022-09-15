package com.gft.starter.gatewayauth.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		 return builder.routes()
				 	.route(r -> r.path("/nutritionist/**")
	                		.uri("http://localhost:8082/"))	                		
				 			//.id("nutritionist"))	                
				 	
				 	.route(r -> r.path("/user/**")
				 			.uri("http://localhost:8083/"))
	                		//.id("user"))
	                
	                .route(r -> r.path("/bookkeeper/**")
	                		.uri("http://localhost:8084/"))
	                		//.id("bookkeeper"))
	                
	                .route(r -> r.path("/auth/**")
	                		.uri("http://localhost:8080/"))
	                		//.id("gateway"))
	                .build();
	}
}
