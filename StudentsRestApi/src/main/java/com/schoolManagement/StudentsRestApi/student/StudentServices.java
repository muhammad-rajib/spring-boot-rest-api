package com.schoolManagement.StudentsRestApi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.time.Month;
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
}
