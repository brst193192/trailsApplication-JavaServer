package com.example.server_side;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.server_side.Converters.FavoriteConverter;
import com.example.server_side.Converters.TrailConverter;
import com.example.server_side.Converters.UserConverter;

@SpringBootApplication
public class ServerSideApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerSideApplication.class, args);
	}

	@Bean
	public UserConverter getUserConverter() {
		return new UserConverter();
	}

	@Bean
	public TrailConverter getTrailCoverter() {
		return new TrailConverter();
	}

	@Bean
	public FavoriteConverter getFavoriteConverter() {
		return new FavoriteConverter();
	}

	// הגדרת CORS לכל האפליקציה
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // מאפשר לכל ה-EndPoints
						.allowedOrigins("*") // מאפשר גישה מכל מקור
						.allowedMethods("*") // מאפשר את כל שיטות ה-HTTP (GET, POST, PUT, DELETE וכו')
						.allowedHeaders("*") // מאפשר כל Header
						.allowCredentials(false); // אם אין צורך ב-Cookies, השאר false
			}
		};
	}
}