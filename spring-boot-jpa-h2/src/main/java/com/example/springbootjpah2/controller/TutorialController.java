package com.example.springbootjpah2.controller;

import com.example.springbootjpah2.model.Tutorial;
import com.example.springbootjpah2.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;


    @PostMapping(path = "tutorial", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> addTutorial(@RequestBody Tutorial tutorial)  {
        try {

            Tutorial tutorialSaved = tutorialService.createTutorial(tutorial);

            return new ResponseEntity<>(tutorialSaved, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // --------------------------------------------------------------------------------

    @GetMapping(path = "tutorials")
    @ResponseBody
    public ResponseEntity<?> getAllTutorial()  {
        try {

            List<Tutorial> tutorials = tutorialService.getAllTutorials();

            return new ResponseEntity<>(tutorials, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // --------------------------------------------------------------------------------



}
