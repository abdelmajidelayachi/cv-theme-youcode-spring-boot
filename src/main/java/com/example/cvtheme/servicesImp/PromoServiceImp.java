package com.example.cvtheme.servicesImp;

import com.example.cvtheme.entities.PromoEntity;
import com.example.cvtheme.repositories.PromoRepository;
import com.example.cvtheme.services.PromoService;
import com.example.cvtheme.shared.dto.PromoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromoServiceImp implements PromoService {
    @Autowired
    PromoRepository promoRepository;

    @Override
    public PromoDto createPromo(PromoDto promo) {
        String promoReferenceName = promo.getName().replace(" ", "_").toLowerCase(); // create the referenceName
        promo.setPromoReferenceName(promoReferenceName);
        promo.setMajor(promo.getMajor().toUpperCase()); // set the major to uppercase
        PromoEntity promoEntity = new PromoEntity();
        BeanUtils.copyProperties(promo, promoEntity);
        PromoEntity newPromo = promoRepository.save(promoEntity);
        PromoDto promoDto = new PromoDto();
        BeanUtils.copyProperties(newPromo, promoDto);
        return promoDto;
    }

    @Override
    public List<PromoDto> getAllPromos() {
        List<PromoEntity> promoEntityList =(List<PromoEntity>) promoRepository.findAll();
        List<PromoDto> promoDtoList = new ArrayList<PromoDto>();
        for(PromoEntity promoEntity: promoEntityList) {
            promoDtoList.add(new PromoDto());
            BeanUtils.copyProperties(promoEntity, promoDtoList.get(promoDtoList.size()-1));
        }
        return promoDtoList;
    }

    @Override
    public PromoDto getByPromoReferenceName(String promoReferenceName) {
        PromoEntity promoEntity = promoRepository.findByPromoReferenceName(promoReferenceName);
        PromoDto promoDto = new PromoDto();
        BeanUtils.copyProperties(promoEntity, promoDto);
        return promoDto;
    }

    @Override
    public void deletePromo(String promoReferenceName) {
        PromoEntity promoEntity = promoRepository.findByPromoReferenceName(promoReferenceName);
        if(promoEntity == null) throw new RuntimeException("Promo not found");
        promoRepository.delete(promoEntity);
    }
}
