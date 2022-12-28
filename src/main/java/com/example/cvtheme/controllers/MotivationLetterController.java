package com.example.cvtheme.controllers;

import com.example.cvtheme.payload.requests.MotivationLetterRequest;
import com.example.cvtheme.services.MotivationLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/motivation-letter")
public class MotivationLetterController {

    private final MotivationLetterService motivationLetterService;

    @Autowired
    public MotivationLetterController(MotivationLetterService motivationLetterService) {
        this.motivationLetterService = motivationLetterService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getMotivationLetter(){
        return ResponseEntity.ok(Map.of("status",true, "message", "Motivation Letter found successfully", "data", motivationLetterService.findAllMotivationLetter()));
    }

    @GetMapping(path = "{motivationLetterId}")
    public ResponseEntity<Map<String, Object>> getMotivationLetterById(@PathVariable Long motivationLetterId){
        return ResponseEntity.ok(Map.of("status",true, "message", "Motivation Letter found successfully", "data", motivationLetterService.findMotivationLetterById(motivationLetterId)));
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> saveMotivationLetter(@RequestBody MotivationLetterRequest motivationLetterRequest){
        return ResponseEntity.ok(Map.of("status",true, "message", "Motivation Letter saved successfully", "data", motivationLetterService.saveMotivationLetter(motivationLetterRequest)));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Map<String, Object>> updateMotivationLetter(@RequestBody MotivationLetterRequest motivationLetterRequest, @PathVariable Long id){
        return ResponseEntity.ok(Map.of("status",true, "message", "Motivation Letter updated successfully", "data", motivationLetterService.updateMotivationLetter(motivationLetterRequest, id)));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, Object>> deleteMotivationLetter(@PathVariable Long id){
        motivationLetterService.deleteMotivationLetter(id);
        return ResponseEntity.ok(Map.of("status",true, "message", "Motivation Letter deleted successfully"));
    }
}
