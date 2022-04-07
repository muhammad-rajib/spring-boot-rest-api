package com.schoolManagement.StudentsRestApi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void updateStudent(
            Long studentId,
            Student updateStudentRecord
    )
    {
        Student currentStudent = studentDBRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + studentId + " does not exist"
                ));

        // name
        if (updateStudentRecord.getName() != null) {
            currentStudent.setName(updateStudentRecord.getName());
        }
        // department
        if (updateStudentRecord.getDepartment() != null) {
            currentStudent.setDepartment(updateStudentRecord.getDepartment());
        }
        // birthdate
        if (updateStudentRecord.getBirth_date() != null) {
            currentStudent.setBirth_date(updateStudentRecord.getBirth_date());
        }
        // admit year
        if (updateStudentRecord.getAdmit_year() != 0) {
            currentStudent.setAdmit_year(updateStudentRecord.getAdmit_year());
        }
        // address
        if (updateStudentRecord.getAddress() != null) {
            currentStudent.setAddress(updateStudentRecord.getAddress());
        }
    }

    public void deleteStudent(Long id) {

        boolean isExist = studentDBRepository.existsById(id);

        if (!isExist) {
            throw new IllegalStateException("Student not found with this " + id);
        }
        studentDBRepository.deleteById(id);
    }
}
