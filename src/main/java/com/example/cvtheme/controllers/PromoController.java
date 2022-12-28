package com.example.cvtheme.controllers;


import com.example.cvtheme.requests.PromoRequest;
import com.example.cvtheme.responses.PromoResponse;
import com.example.cvtheme.services.PromoService;
import com.example.cvtheme.shared.dto.PromoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/promo")
public class PromoController {
    @Autowired
    PromoService promoService;

    @GetMapping("/all")
    private ResponseEntity<List<PromoResponse>> getPromos() {
        List<PromoDto> promoDtoList = promoService.getAllPromos();
        List<PromoResponse> promoResponses = new ArrayList<PromoResponse>();
        for(PromoDto promoDto: promoDtoList) {
            promoResponses.add(new PromoResponse());
            BeanUtils.copyProperties(promoDto, promoResponses.get(promoResponses.size()-1));
        }
        return new ResponseEntity<List<PromoResponse>>(promoResponses, HttpStatus.OK);
    }

    @GetMapping("/{referenceName}")
    private ResponseEntity<PromoResponse> getByName(@PathVariable String referenceName) {
        PromoDto promoDto = promoService.getByPromoReferenceName(referenceName);
        PromoResponse promoResponse = new PromoResponse();
        BeanUtils.copyProperties(promoDto, promoResponse);
        return new ResponseEntity<PromoResponse>(promoResponse, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<PromoResponse> createPromo(@RequestBody PromoRequest promoRequest) {
        PromoDto promoDto = new PromoDto();
        BeanUtils.copyProperties(promoRequest, promoDto);
        PromoDto createPromo = promoService.createPromo (promoDto);
        PromoResponse promoResponse = new PromoResponse();
        BeanUtils.copyProperties(createPromo, promoResponse);
        return new ResponseEntity<PromoResponse>(promoResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{referenceName}")
    private ResponseEntity<Object> deletePromo(@PathVariable String referenceName) {
        promoService.deletePromo(referenceName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
