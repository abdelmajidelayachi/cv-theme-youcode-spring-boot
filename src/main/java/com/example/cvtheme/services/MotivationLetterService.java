package com.example.cvtheme.services;

import com.example.cvtheme.entities.MotivationLetter;
import com.example.cvtheme.payload.requests.MotivationLetterRequest;
import com.example.cvtheme.repository.MotivationLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MotivationLetterService {

    private final MotivationLetterRepository motivationLetterRepository;

    @Autowired
    public MotivationLetterService(MotivationLetterRepository motivationLetterRepository) {
        this.motivationLetterRepository = motivationLetterRepository;
    }

    /**
     * @return List<MotivationLetter>
     */
    public List<MotivationLetter> findAllMotivationLetter(){
        return (List<MotivationLetter>) motivationLetterRepository.findAll();
    }

    /**
     * @param motivationLetterRequest
     * @return MotivationLetter
     */
    public MotivationLetter saveMotivationLetter(MotivationLetterRequest motivationLetterRequest){
        MotivationLetter motivationLetter = new MotivationLetter();
        motivationLetter.setLetterName(motivationLetterRequest.getName());
        motivationLetter.setLetterContent(motivationLetterRequest.getContent());
        motivationLetter.setStudentId(motivationLetterRequest.getStudentId());
        return motivationLetterRepository.save(motivationLetter);
    }

    /**
     * @param motivationLetterId
     * @return MotivationLetter
     */
    public MotivationLetter findMotivationLetterById(Long motivationLetterId){
        return motivationLetterRepository.findById(motivationLetterId).orElse(null);
    }

    /**
     * @param motivationLetterId
     * @return MotivationLetter
     */
    @Transactional
    public MotivationLetter updateMotivationLetter(MotivationLetterRequest motivationLetterRequest, Long motivationLetterId){
        MotivationLetter motivationLetter = findMotivationLetterById(motivationLetterId);
        if (motivationLetter != null){
            motivationLetter.setLetterName(motivationLetterRequest.getName());
            motivationLetter.setLetterContent(motivationLetterRequest.getContent());
            motivationLetter.setStudentId(motivationLetterRequest.getStudentId());
        }else{
            throw new RuntimeException("Motivation Letter not found with id: " + motivationLetterId);
        }
        return motivationLetter;
    }
    /**
     * @param motivationLetterId
     */
    public void deleteMotivationLetter(Long motivationLetterId){
        motivationLetterRepository.deleteById(motivationLetterId);
    }
}
