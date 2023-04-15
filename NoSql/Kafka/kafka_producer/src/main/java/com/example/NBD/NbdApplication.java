package com.example.NBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories()
public class NbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbdApplication.class, args);
	}

}
