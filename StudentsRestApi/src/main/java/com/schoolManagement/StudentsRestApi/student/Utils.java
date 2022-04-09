package com.schoolManagement.StudentsRestApi.student;

import java.util.ArrayList;
import java.util.List;


public class Utils
{
    public static StudentResponse SingleObjToJson(Student student)
    {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getDepartment(),
                student.getBirth_date(),
                student.getAdmit_year(),
                student.getAddress()
        );
    }

    public static List<StudentResponse> MultiObjToJson(List<Student> stdLst) {

        List<StudentResponse> returnLst = new ArrayList<>();

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

        return returnLst;
    }
}
