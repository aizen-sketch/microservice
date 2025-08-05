package com.example.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	@Bean
	public WebFluxConfigurer corsConfigurer() {
	    return new WebFluxConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("*") 
	                    .allowedMethods("*")
	                    .allowedHeaders("*")
	                    .allowCredentials(true);
	        }
	    };
	}


}
