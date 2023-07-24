package com.goupe2TP.tpAPI.controller;

import com.goupe2TP.tpAPI.model.Question;
import com.goupe2TP.tpAPI.service.QuestionService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    // LA METHODE CREATE
    @PostMapping("/create")
    public Question create(@RequestBody Question question){
        return questionService.creerQuestion(question);
    }
    // LA METHODE READ
    @GetMapping("/read")
    public List<Question> read(){
        return questionService.LireQuestion();
    }

    @GetMapping("/read/{id}")
    public Question read(@PathVariable Long id, @RequestBody Question question){
        return questionService.getQuest(id, question);
    }

    // LA METHODE UPDATE
    @PutMapping("/update/{id}")
    public Question update(@PathVariable Long id, @RequestBody Question question){
        return questionService.modifierQuestion(id, question);
    }
    // LA METHODE DELETE
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        return questionService.supprimerQuestion(id);
    }



}
