package com.goupe2TP.tpAPI.Controleur;

import com.goupe2TP.tpAPI.Entity.Questions;
import com.goupe2TP.tpAPI.Service.Questions_service;
import com.goupe2TP.tpAPI.Service.Quiz_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question")
public class Question_controleur {

    @Autowired
    private Questions_service questionsService;
    @PostMapping("/creat")
    public String createQuestion(@RequestBody Questions questions){
        questionsService.createQuestion(questions);
        return "création avec succès";
    }

    @GetMapping("/readQuestion")
    public List<Questions> readQuestion(){
        return questionsService.readQuestion();
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable int id){
        questionsService.deleteQuestion(id);
        return "delete success";
    }

    @PutMapping("/putQuestion")
    public Questions updateQuestion(@RequestBody Questions questions){
        return questionsService.updateQuestion(questions);
    }
}

