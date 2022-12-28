package com.example.cvtheme.repository;

import com.example.cvtheme.entities.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Teacher findTeacherByPromoId(Long promoId);
}
