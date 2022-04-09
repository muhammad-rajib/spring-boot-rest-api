package com.schoolManagement.StudentsRestApi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/home")
class HomePage {

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
        List<Student> stdLst = studentServices.getStudent();

        List<StudentResponse> returnLst = Utils.MultiObjToJson(stdLst);
        return new ResponseEntity<>(returnLst, HttpStatus.OK);
    }


    @GetMapping(path = "{studentId}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable("studentId") Long studentId)
    {
        Student student = studentServices.getStudentById(studentId);

        StudentResponse std = Utils.SingleObjToJson(student);
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
