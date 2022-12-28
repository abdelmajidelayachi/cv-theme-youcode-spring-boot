package com.example.cvtheme.repository;

import com.example.cvtheme.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsStudentByEmail(String email);
    Student findStudentByEmail(String email);

}
