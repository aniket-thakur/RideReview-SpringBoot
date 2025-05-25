package com.example.ridereviewservice.RideReviewService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RideReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RideReviewServiceApplication.class, args);
	}

}
