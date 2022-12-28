package com.example.cvtheme.repository;

import com.example.cvtheme.entities.Promo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends CrudRepository<Promo, Long> {

}
