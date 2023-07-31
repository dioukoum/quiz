package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Participation;

import com.goupe2TP.tpAPI.repository.ParticipationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ParticipationServiceImpl implements ParticipationService{
    @Autowired
    private final ParticipationRepository participationRepository;

    @Override
    public Participation creerParticipation(Participation participation) {
        return participationRepository.save(participation);
    }

    @Override
    public List<Participation> LireParticipation() {
        return participationRepository.findAll();
    }

    @Override
    public Participation getParticipation(Long id, Participation participation) {
        return participationRepository.findById(id).orElseThrow(()-> new RuntimeException("Participation non trouvé !"));
    }

    @Override
    public Participation modifierParticipation(Long id, Participation participation) {
        return participationRepository.findById(id).map(p ->{

            p.setUtilisateur(participation.getUtilisateur());
            p.setScores(participation.getScores());
            p.setQuiz(participation.getQuiz());

            return participationRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Participation non trouvé !"));
    }

    @Override
    public String supprimerParticipation(Long id) {
        Participation participation = participationRepository.findById(id).orElseThrow(()-> new RuntimeException("Participation non trouvé !"));

        if (participation != null ){
            participationRepository.deleteById(participation.getId());
            return "Participation supprimer avec succès !";
        }
        if (participation == null){
            return "Participation non trouvé !";
        }
        return null;
    }
}
