package com.schoolManagement.StudentsRestApi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServices {

    private final StudentDBRepository studentDBRepository;

    @Autowired
    public StudentServices(StudentDBRepository studentDBRepository) {
        this.studentDBRepository = studentDBRepository;
    }

    public List<Student> getStudent() {
        return studentDBRepository.findAll();
    }

    public void addNewStudent(Student student) {
        studentDBRepository.save(student);
    }
}
