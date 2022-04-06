package com.schoolManagement.StudentsRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentsRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsRestApiApplication.class, args);
	}

	@GetMapping
	public String SchoolManagement() {
		return "Welcome to School Management System !!!";
	}

}
