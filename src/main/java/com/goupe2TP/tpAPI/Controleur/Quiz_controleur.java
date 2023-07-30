package com.goupe2TP.tpAPI.Controleur;

import com.goupe2TP.tpAPI.Entity.Questions;
import com.goupe2TP.tpAPI.Entity.Quiz;
import com.goupe2TP.tpAPI.Entity.utilisateur;
import com.goupe2TP.tpAPI.Service.Questions_service;
import com.goupe2TP.tpAPI.Service.Quiz_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/Quiz")
public class Quiz_controleur {

    @Autowired
    private Quiz_service quizService;

    @Autowired
    private Questions_service questionsService;

    @PostMapping("/add")
    public String addQuiz(@RequestBody Quiz quiz){
        quizService.addQuiz(quiz);
        return "add success";
    }

    @GetMapping("/readQuiz")
    public List<Quiz> readQuiz(){
        return quizService.readQuiz();
    }



    @PutMapping("/updat")
    public Quiz updateQuiz(@RequestBody Quiz quiz){
        quizService.updateQuiz(quiz);
        return quiz;
    }

    @DeleteMapping("/deleteQuiz/{id}")
    public String deleteQuiz(@PathVariable int id){
        quizService.delete(id);
        return "successful delete";
    }

    //methode Slection
    @PostMapping("/utilisateur/{id}/quiz")
    public Quiz addQuizUser(@PathVariable int id, @RequestBody Quiz quiz){
        return quizService.addQuizUser(id, quiz);
    }

    @GetMapping("/select/{id}")
    public Quiz select(@PathVariable int id){
        return quizService.select(id);
    }


}
