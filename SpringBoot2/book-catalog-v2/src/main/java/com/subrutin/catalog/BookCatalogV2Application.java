package com.subrutin.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookCatalogV2Application {

	// ini file utama (main class)
	public static void main(String[] args) {
		SpringApplication.run(BookCatalogV2Application.class, args);
	}
}
