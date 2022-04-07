package com.schoolManagement.StudentsRestApi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/home")
class HomeUrl {

    @GetMapping
    public ResponseEntity<String> homePage() {
        return new ResponseEntity<>(
                "Welcome to School Management System ...",
                HttpStatus.OK
        );
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
    public ResponseEntity<List<StudentResponse>> getStudents()
    {
        List<StudentResponse> returnLst = new ArrayList<>();

        List<Student> stdLst = studentServices.getStudent();
        for (Student student : stdLst) {
            StudentResponse std = new StudentResponse(
                    student.getId(),
                    student.getName(),
                    student.getDepartment(),
                    student.getBirth_date(),
                    student.getAdmit_year(),
                    student.getAddress()
            );
            returnLst.add(std);
        }
        return new ResponseEntity<>(returnLst, HttpStatus.OK);
    }


    @GetMapping(path = "{studentId}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable("studentId") Long studentId)
    {
        Student student = studentServices.getStudentById(studentId);
        StudentResponse std = new StudentResponse(
                student.getId(),
                student.getName(),
                student.getDepartment(),
                student.getBirth_date(),
                student.getAdmit_year(),
                student.getAddress()
        );
        return new ResponseEntity<>(std, HttpStatus.FOUND);
    }


    @PostMapping
    public ResponseEntity<String> registerNewStudent(@RequestBody Student student)
    {
        studentServices.addNewStudent(student);
        return new ResponseEntity<>(
                "Successfully created",
                HttpStatus.CREATED
        );
    }


    @PutMapping(path = "{studentId}")
    public ResponseEntity<String> updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody Student student
    )
    {
        studentServices.updateStudent(studentId, student);
        return new ResponseEntity<>(
                "Successfully updated",
                HttpStatus.OK
        );
    }


    @DeleteMapping(path = "{StudentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("StudentId") Long studentId)
    {
        studentServices.deleteStudent(studentId);
        return new ResponseEntity<>(
                "Successfully Deleted",
                HttpStatus.OK
        );
    }

}
