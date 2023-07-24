package com.goupe2TP.tpAPI.controller;

import com.goupe2TP.tpAPI.model.Quiz;
import com.goupe2TP.tpAPI.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // LA METHODE CREATE
    @PostMapping("/create")
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.creerQuiz(quiz);
    }

    // LA METHODE READ
    @GetMapping("/read")
    public List<Quiz> read(){
        return quizService.LireQuiz();
    }
    @GetMapping("/read/{id}")
    public Quiz read(@PathVariable Long id, @RequestBody Quiz quiz){
        return quizService.getUser(id, quiz);
    }

    // LA METHODE UPDATE
    @PutMapping("/update/{id}")
    public Quiz update(@PathVariable Long id, @RequestBody Quiz quiz){
        return quizService.modifierQuiz(id, quiz);
    }
    // LA METHODE DELETE
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        return quizService.supprimerQuiz(id);
    }
}
