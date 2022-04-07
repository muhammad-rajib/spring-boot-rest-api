package com.schoolManagement.StudentsRestApi.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentDBRepository extends JpaRepository<Student, Long> {
    /* this interface is responsible for data access from database */

    // select * from student where email = <givenEmail>;
    /*
    * Optional is a new container type that wraps a single value, if the value is available.
    * So it's meant to convey the meaning that the value might be absent.
    */
    Optional<Student> findByEmail(String email);
}
