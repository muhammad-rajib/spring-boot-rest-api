package com.schoolManagement.StudentsRestApi.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    @Column(name = "student_id")
    private Long id;
    private String name;
    private String department;
    private LocalDate birth_date;

    @Transient
    private int age;

    private int admit_year;
    private String email;
    private String address;

    public Student() {

    }

    public Student(
            Long id,
            String name,
            String department,
            LocalDate birth_date,
            int admit_year,
            String email,
            String address
    )
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.birth_date = birth_date;
        this.admit_year = admit_year;
        this.email = email;
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

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public int getAdmit_year() {
        return admit_year;
    }

    public void setAdmit_year(int admit_year) {
        this.admit_year = admit_year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
