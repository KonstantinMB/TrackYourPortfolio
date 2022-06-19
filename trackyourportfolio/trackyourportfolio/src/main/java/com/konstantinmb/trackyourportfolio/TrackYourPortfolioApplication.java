package com.konstantinmb.trackyourportfolio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.konstantinmb.trackyourportfolio.event.UserPayload;
import com.konstantinmb.trackyourportfolio.repository.UserRepository;
import com.konstantinmb.trackyourportfolio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.function.Consumer;

@SpringBootApplication
@AllArgsConstructor
@EnableEurekaClient
public class TrackYourPortfolioApplication {

	private final UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(TrackYourPortfolioApplication.class, args);
	}

	@Bean
	public Consumer<Message<UserPayload>> userInfoEventSupplier() {
		return message -> {
			try {
				new UserService(userRepo).saveUserToDB(message.getPayload());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
}
