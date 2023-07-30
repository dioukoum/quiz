package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Entity.Participants;
import com.goupe2TP.tpAPI.Entity.Quiz;
import com.goupe2TP.tpAPI.Entity.utilisateur;
import com.goupe2TP.tpAPI.Repository.Repository_participant;
import com.goupe2TP.tpAPI.Repository.Repository_quiz;
import com.goupe2TP.tpAPI.Repository.Repository_utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Participant_service {
    @Autowired
    private Repository_participant repositoryParticipant;

    @Autowired
    private Repository_quiz repositoryQuiz;

    @Autowired
    Repository_utilisateur repositoryUtilisateur;


    public String addParticipant(Participants participants){
        repositoryParticipant.save(participants);
        return "ajout avec succès";
    }

    public List<Participants> getParticipant(){
        return repositoryParticipant.findAll();
    }

}
