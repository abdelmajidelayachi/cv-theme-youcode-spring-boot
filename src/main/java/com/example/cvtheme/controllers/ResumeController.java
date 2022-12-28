package com.example.cvtheme.controllers;

import com.example.cvtheme.entities.Resume;
import com.example.cvtheme.payload.requests.ResumeRequest;
import com.example.cvtheme.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllResume(){
        return ResponseEntity.ok(Map.of("status","success","data", resumeService.findAllResume()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findResumeById(@PathVariable Long id){
        return ResponseEntity.ok(Map.of("status","success","data", resumeService.findResumeById(id)));
    }
    @PostMapping
    public ResponseEntity<Map<String, String>> createResume(@RequestBody ResumeRequest resumeRequest){
        Resume resume = resumeService.saveResume(resumeRequest);
        if (resume != null) return ResponseEntity.ok(Map.of("message", "Resume created successfully"));
        else return ResponseEntity.badRequest().body(Map.of("message", "Resume not created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateResume(@RequestBody ResumeRequest resumeRequest, @PathVariable Long id){
        Resume resume = resumeService.updateResume(resumeRequest, id);
        if (resume != null) return ResponseEntity.ok(Map.of("message", "Resume updated successfully"));
        else return ResponseEntity.badRequest().body(Map.of("message", "Resume not updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteResume(@PathVariable Long id){
        resumeService.deleteResume(id);
        return ResponseEntity.ok(Map.of("message", "Resume deleted successfully"));
    }
}