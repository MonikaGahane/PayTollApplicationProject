package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ProjectConfig {
	
	@Bean
	ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
