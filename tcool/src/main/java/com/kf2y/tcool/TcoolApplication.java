package com.kf2y.tcool;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.kf2y.tcool.service.file.FilesStorageService;

@EnableJpaAuditing
@SpringBootApplication
public class TcoolApplication implements CommandLineRunner{
	
	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(TcoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.init();
		
	}

}
