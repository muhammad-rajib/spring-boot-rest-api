package com.schoolManagement.StudentsRestApi.student;

import java.time.LocalDate;
import java.time.Period;

public class StudentResponse {

    private Long id;
    private String name;
    private String department;
    private LocalDate birth_date;
    private int age;
    private int admit_year;
    private String address;


    public StudentResponse(
            Long id,
            String name,
            String department,
            LocalDate birth_date,
            int admit_year,
            String address
    )
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.birth_date = birth_date;
        this.age = getAge();
        this.admit_year = admit_year;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return Period.between(this.birth_date, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAdmit_year() {
        return admit_year;
    }

    public void setAdmit_year(int admit_year) {
        this.admit_year = admit_year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
