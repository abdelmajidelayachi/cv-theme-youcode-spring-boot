package com.example.cvtheme.repositories;

import com.example.cvtheme.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
}
