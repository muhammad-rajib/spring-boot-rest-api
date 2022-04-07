package com.schoolManagement.StudentsRestApi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long studentId) {
        return studentServices.getStudentById(studentId);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentServices.addNewStudent(student);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody Student student
    ) {
        studentServices.updateStudent(studentId, student);
    }

    @DeleteMapping(path = "{StudentId}")
    public void deleteStudent(@PathVariable("StudentId") Long studentId) {
        studentServices.deleteStudent(studentId);
    }

}
