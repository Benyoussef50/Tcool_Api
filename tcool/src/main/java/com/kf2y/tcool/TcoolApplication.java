package com.kf2y.tcool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class TcoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcoolApplication.class, args);
	}

}
