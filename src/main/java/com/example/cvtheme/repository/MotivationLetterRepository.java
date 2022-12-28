package com.example.cvtheme.repository;

import com.example.cvtheme.entities.MotivationLetter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivationLetterRepository extends CrudRepository<MotivationLetter, Long> {
    //
}
