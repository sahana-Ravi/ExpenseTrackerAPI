package com.roadmap.sh.AdvancedTrackerApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AdvancedTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedTrackerApiApplication.class, args);
	}

}
