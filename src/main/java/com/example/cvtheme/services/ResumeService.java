package com.example.cvtheme.services;

import com.example.cvtheme.entities.Resume;
import com.example.cvtheme.payload.requests.ResumeRequest;
import com.example.cvtheme.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public List<Resume> findAllResume() {
        return (List<Resume>) resumeRepository.findAll();
    }

    /**
     * @param resumeRequest
     * @return Resume
     */
    public Resume saveResume(ResumeRequest resumeRequest){
        Resume resume = new Resume();
        resume.setResumeName(resumeRequest.getName());
        resume.setStudentId(resumeRequest.getStudentId());
        resume.setFileName(resumeRequest.getFileName());
        return resumeRepository.save(resume);
    }

    /**
     * @param resumeId
     * @return Resume
     */
    public Resume findResumeById(Long resumeId){
        return resumeRepository.findById(resumeId).orElse(null);
    }

    /**
     * @param resumeId
     * @return Resume
     */
    @Transactional
    public Resume updateResume(ResumeRequest resumeRequest, Long resumeId){
        Resume resume = findResumeById(resumeId);
        if (resume != null){
            resume.setResumeName(resumeRequest.getName());
            resume.setStudentId(resumeRequest.getStudentId());
            resume.setFileName(resumeRequest.getFileName());
        }else{
            throw new RuntimeException("Resume not found with id: " + resumeId);
        }
        return resume;
    }

    /**
     * @param resumeId
     */
    public void deleteResume(Long resumeId){
        if (resumeRepository.existsById(resumeId)) resumeRepository.deleteById(resumeId);
        else throw new IllegalStateException("Resume with id " + resumeId + " does not exist");
    }

}
