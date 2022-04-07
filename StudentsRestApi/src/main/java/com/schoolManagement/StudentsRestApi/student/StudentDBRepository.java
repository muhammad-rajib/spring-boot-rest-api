package com.schoolManagement.StudentsRestApi.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentDBRepository extends JpaRepository<Student, Long> {
    /* this interface is responsible for data access from database */

}
