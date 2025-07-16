package com.example.TableService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TableServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TableServiceApplication.class, args);
	}

}
