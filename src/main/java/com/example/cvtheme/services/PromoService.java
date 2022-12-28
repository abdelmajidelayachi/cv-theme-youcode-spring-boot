package com.example.cvtheme.services;

import com.example.cvtheme.entities.Promo;
import com.example.cvtheme.payload.requests.PromoRequest;
import com.example.cvtheme.repository.PromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoService {

    private PromoRepository promoRepository;

    @Autowired
    public PromoService(PromoRepository promoRepository) {
        this.promoRepository = promoRepository;
    }
    /**
     * @return List<Promo>
     */
    public List<Promo> findAllPromo() {
        return (List<Promo>) promoRepository.findAll();
    }

    /**
     * @param promoRequest
     * @return Promo
     */
    public Promo savePromo(PromoRequest promoRequest){
        Promo promo = new Promo();
        promo.setName(promoRequest.getName());
        promo.setMajor(promoRequest.getMajor());
        promo.setYear(promoRequest.getYear());
        return promoRepository.save(promo);
    }

    /**
     * @param promoId
     * @return Promo
     */
    public Promo findPromoById(Long promoId){
        return promoRepository.findById(promoId).orElse(null);
    }

    /**
     * @param promoId
     * @return Promo
     */
    public Promo updatePromo(PromoRequest promoRequest, Long promoId){
        Promo promo = findPromoById(promoId);
        if (promo != null){
            promo.setName(promoRequest.getName());
            promo.setMajor(promoRequest.getMajor());
            promo.setYear(promoRequest.getYear());
        }else{
            throw new RuntimeException("Promo not found with id: " + promoId);
        }
        return promo;
    }

    /**
     * @param promoId
     */
    public void deletePromo(Long promoId){
        promoRepository.deleteById(promoId);
    }

}
