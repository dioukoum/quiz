package com.goupe2TP.tpAPI.Controleur;

import com.goupe2TP.tpAPI.Entity.Questions;
import com.goupe2TP.tpAPI.Entity.Quiz;
import com.goupe2TP.tpAPI.Entity.utilisateur;
import com.goupe2TP.tpAPI.Service.Quiz_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Quiz")
public class Quiz_controleur {

    @Autowired
    private Quiz_service quizService;

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

    /*@GetMapping("/{quizId}/getparticipants")
    public ResponseEntity<Set<utilisateur>> getParticipantsByQuizId(@PathVariable Long quizId) {
        Set<utilisateur> participants = quizService.getUsersByQuizId(quizId);
        if (!participants.isEmpty()) {
            return ResponseEntity.ok(participants);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{quizId}/addparticipants")
    public ResponseEntity<String> addParticipantToQuiz(@PathVariable Long quizId, @RequestBody utilisateur participant) {
        boolean added = quizService.addParticipantToQuiz(quizId, participant);
        if (added) {
            return ResponseEntity.ok("Participant ajouté avec succès au quiz.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/participants")
    public ResponseEntity<Set<utilisateur>> getAllParticipants() {
        Set<utilisateur> allParticipants = quizService.getAllParticipants();
        if (!allParticipants.isEmpty()) {
            return ResponseEntity.ok(allParticipants);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @GetMapping("/")
    public List<Questions> getQuizQuestion(@RequestBody int idQuiz){
        return quizService.
    }

}
