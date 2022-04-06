package com.schoolManagement.StudentsRestApi.student;

import java.time.LocalDate;

public class Student {

    private Long id;
    private String name;
    private String department;
    private LocalDate birth_date;
    private int age;
    private int admit_year;
    private Long contact;
    private String address;

    public Student() {

    }

    public Student(
            Long id,
            String name,
            String department,
            LocalDate birth_date,
            int age,
            int admit_year,
            Long contact,
            String address
    )
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
        this.admit_year = admit_year;
        this.contact = contact;
        this.address = address;
    }
}
