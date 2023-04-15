package com.example.NBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories
@SpringBootApplication
public class NbdApplication extends RuntimeException{

	public static void main(String[] args) {
		SpringApplication.run(NbdApplication.class, args);
	}

}
