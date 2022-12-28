package com.example.cvtheme.repositories;

import com.example.cvtheme.entities.PromoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends CrudRepository<PromoEntity, Long> {
    PromoEntity findByPromoReferenceName(String referenceName);

}
