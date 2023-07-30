package com.goupe2TP.tpAPI.Controleur;

/*import com.goupe2TP.tpAPI.Entity.Questions;
import com.goupe2TP.tpAPI.Entity.Quiz;
import com.goupe2TP.tpAPI.Entity.Reponse;
import com.goupe2TP.tpAPI.Service.Questions_service;
import com.goupe2TP.tpAPI.Service.Quiz_service;
import com.goupe2TP.tpAPI.Service.Reponse_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/joy_quiz")
public class Jouer {
    @Autowired
    private Questions_service questionsService;

    @Autowired
    private Quiz_service quizService;

    @Autowired
    private Reponse_service reponseService;



    @GetMapping
    public List<Quiz> readQuiz(){
        return quizService.readQuiz();
    }

    @GetMapping("/quiz/{id}")
    public Quiz getQuiz(@PathVariable int id){
        return quizService.getRepositoryQuiz().findById(id);
    }

    @GetMapping("/quiz/{id}/questions")
    public List<Questions> getQuestion(@PathVariable int id) {
        List<Questions> questions = questionsService.getQuestion(id);
        if( questions!= null){
            return questions;
        }else{
            throw new IllegalArgumentException("obligation");
        }
    }


    @GetMapping("/quiz/{idQuiz}/questions/reponse/{id}")
    public List<Reponse> getReponse(@PathVariable(name = "id", required = true) int id){
        if(id <= 0){
            throw new IllegalArgumentException("le choix de la question est obligatoire");
        }
        return reponseService.getReponse(id);
    }
}*/
