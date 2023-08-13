package com.example.springbootjpah2.service;

import com.example.springbootjpah2.model.Tutorial;
import com.example.springbootjpah2.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {


    @Autowired
    TutorialRepository tutorialRepository;

    public Tutorial getTutorialById(Long id) throws Exception {
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);

        if(tutorialOptional.isPresent()){
            return tutorialOptional.get();
        }

        throw new Exception("Tutorial for id "+id+" not found");

    }

    public List<Tutorial> getAllTutorials() throws Exception {
        List<Tutorial> tutorials = tutorialRepository.findAll();

        if(!tutorials.isEmpty()){
            return tutorials;
        }

        throw new Exception("No tutorials found");

    }

    public Tutorial createTutorial(Tutorial tutorial) throws Exception {
        Tutorial savedTutorial = tutorialRepository.save(tutorial);

        if(savedTutorial != null){
            return savedTutorial;
        }

        throw new Exception("No tutorials saved");
    }

    public Tutorial updateTutorial(Tutorial tutorial) throws Exception {
        Tutorial updatedTutorial = tutorialRepository.save(tutorial);

        if(updatedTutorial != null){
            return updatedTutorial;
        }

        throw new Exception("No tutorials updated");
    }

    public void deleteTutorial(Tutorial tutorial) throws Exception {
        tutorialRepository.delete(tutorial);

    }
}
