package com.schoolManagement.StudentsRestApi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/home")
class HomeUrl {

    @GetMapping
    public String homePage() {
        return "Welcome to School Management System !!!";
    }
}


@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentServices.getStudent();
    }

}
