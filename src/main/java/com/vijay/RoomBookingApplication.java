package com.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RoomBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomBookingApplication.class, args);
	}
	
	/* Trash Code - By VijayRavi */
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {				
		        registry.addMapping("/**")
		        .allowedOrigins("*")
		        .allowedMethods("GET", "POST", "OPTIONS", "PUT")
//                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
//                        "Access-Control-Request-Headers")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
//                .allowCredentials(true).maxAge(3600);
			}
		};
	}

}
