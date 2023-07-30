package com.goupe2TP.tpAPI.Controleur;

import com.goupe2TP.tpAPI.Entity.*;
import com.goupe2TP.tpAPI.Repository.Repository_quiz;
import com.goupe2TP.tpAPI.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/joy_quiz")
public class Participant_contriller {

    @Autowired
    private Questions_service questionsService;

    @Autowired
    private utilisateur_service utilisateurService;

    @Autowired
    private Quiz_service quizService;

    @Autowired
    Repository_quiz repositoryQuiz;

    @Autowired
    private Reponse_service reponseService;

    @Autowired
    private Participant_service participantService;

    @GetMapping("/connexion")
    public Object utilisateur(@RequestParam("email") String email, @RequestParam("motDePasse") String motDePasse){
        utilisateur verification = utilisateurService.connexion(email, motDePasse);
        if (verification != null){
            return verification;
        }else{
            return "cet utilisateur n'existe pas";
        }
    }
    @GetMapping("/list")
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



    @PostMapping("/add")
    public String add(@RequestBody Participants participants){
        return participantService.addParticipant(participants);
    }

    @GetMapping("/read")
    public List<Participants> read(){
        return participantService.getParticipant();
    }


    //=====================================jouer==================================

    @GetMapping("/")
    public List<String> quizlist(){
        return quizService.quizParticipe();
    }

    @GetMapping("/{idUser}/{idQuiz}/joy")
    public List<String> joy(@PathVariable int idUser, @PathVariable int idQuiz, @RequestParam(value = "choix",required = false) Integer choix ) {
        if(choix==null){
            return quizService.ready(idUser, idQuiz);
        }else {
            return quizService.reponse(idUser,idQuiz,choix);
        }

    }
}
