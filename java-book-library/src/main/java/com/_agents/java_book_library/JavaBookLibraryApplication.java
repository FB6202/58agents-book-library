package com._agents.java_book_library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaBookLibraryApplication {

	public static void main(String[] args) {
		System.out.println(System.getenv("POSTGRES_USER"));
		System.out.println(System.getenv("POSTGRES_PASSWORD"));
		System.out.println(System.getenv("POSTGRES_DB"));
		SpringApplication.run(JavaBookLibraryApplication.class, args);
	}

}
