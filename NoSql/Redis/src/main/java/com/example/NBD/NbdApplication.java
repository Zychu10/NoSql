package com.example.NBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableCaching
public class NbdApplication extends RuntimeException{

	public static void main(String[] args) {
		SpringApplication.run(NbdApplication.class, args);
	}

}
