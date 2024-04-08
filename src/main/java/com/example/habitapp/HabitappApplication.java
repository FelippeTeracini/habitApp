package com.example.habitapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HabitappApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabitappApplication.class, args);
	}

}
