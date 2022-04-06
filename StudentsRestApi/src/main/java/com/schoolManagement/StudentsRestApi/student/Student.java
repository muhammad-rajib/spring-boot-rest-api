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
        return age;
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

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                "name=" + name + '\'' +
                "department=" + department + '\'' +
                "admitYear=" + admit_year +
                "}";
    }
}
