package com.example.demo.controller;

import com.example.demo.model.Sentence;
import com.example.demo.service.WordCountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WordCountController {
    private final WordCountService wordCountService;

    @Autowired
    public WordCountController(WordCountService wordCountService) {
        this.wordCountService = wordCountService;
    }

    @PostMapping("/words/count")
    @ResponseBody
    public ResponseEntity word(@RequestBody Sentence sentence){

        return new ResponseEntity<>(
                wordCountService.count(sentence.getSentence()),
                HttpStatus.OK);

    }

}
