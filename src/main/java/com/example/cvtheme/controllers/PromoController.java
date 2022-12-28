package com.example.cvtheme.controllers;

import com.example.cvtheme.payload.requests.PromoRequest;
import com.example.cvtheme.services.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/promo")
public class PromoController {

    private final PromoService promoService;

    @Autowired
    public PromoController(PromoService promoService) {
        this.promoService = promoService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> savePromo(@RequestBody PromoRequest promoRequest){
        return ResponseEntity.ok(Map.of("status",true, "message", "Promo saved successfully", "data", promoService.savePromo(promoRequest)));
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getPromo(){
        return ResponseEntity.ok(Map.of("status",true, "message", "Promo found successfully", "data", promoService.findAllPromo()));
    }

    @PutMapping(path = "{promoId}")
    public ResponseEntity<Map<String, Object>> updatePromo(@RequestBody PromoRequest promoRequest, @PathVariable("promoId") Long id){
        return ResponseEntity.ok(Map.of("status",true, "message", "Promo updated successfully", "data", promoService.updatePromo(promoRequest, id)));
    }

    @DeleteMapping(path = "{promoId}")
    public ResponseEntity<Map<String, Object>> deletePromo(@PathVariable("promoId") Long promoId){
        promoService.deletePromo(promoId);
        return ResponseEntity.ok(Map.of("status",true, "message", "Promo deleted successfully"));
    }
}
