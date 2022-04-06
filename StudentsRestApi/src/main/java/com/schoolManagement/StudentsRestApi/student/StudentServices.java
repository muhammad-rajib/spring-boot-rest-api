package com.schoolManagement.StudentsRestApi.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Service
public class StudentServices {

    public List<Student> getStudent() {
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
