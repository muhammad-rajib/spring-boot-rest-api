package com.schoolManagement.StudentsRestApi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


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

        Optional<Student> studentOptional = studentDBRepository.findByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already exist");
        }
        studentDBRepository.save(student);
    }
}
