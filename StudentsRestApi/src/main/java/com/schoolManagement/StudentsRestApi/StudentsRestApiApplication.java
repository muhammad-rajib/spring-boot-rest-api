package com.schoolManagement.StudentsRestApi;

import com.schoolManagement.StudentsRestApi.student.Student;
import org.apache.catalina.LifecycleState;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@SpringBootApplication
@RestController
public class StudentsRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsRestApiApplication.class, args);
	}

//	@GetMapping
//	public String SchoolManagement() {
//		return "Welcome to School Management System !!!";
//	}

	@GetMapping
	public List<Student> StudentInfo() {
		return List.of(
				new Student (
						1L,
						"Forid",
						"cmt",
						LocalDate.of(2000, Month.APRIL, 10),
						25,
						2019,
						123123,
						"Dhaka, Bangladesh"
				)
		);
	}

}
