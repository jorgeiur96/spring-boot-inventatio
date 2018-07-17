package com.jorge.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jorge.springboot.app.models.service.IUploadFileService;

@SpringBootApplication
public class SpringBootDataJpasApplication implements CommandLineRunner{

	
	
	@Autowired	
	IUploadFileService uploadFileService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		uploadFileService.deleteAll();
		uploadFileService.init();
		
	}
}
