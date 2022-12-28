package com.example.cvtheme.services;

import com.example.cvtheme.shared.dto.PromoDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PromoService {
    PromoDto createPromo(PromoDto promo);
    List<PromoDto> getAllPromos();
    PromoDto getByPromoReferenceName(String promoReferenceName);
    void deletePromo(String promoReferenceName);
}
