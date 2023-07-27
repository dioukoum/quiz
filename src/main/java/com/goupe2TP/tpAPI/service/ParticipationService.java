package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Participation;
import com.goupe2TP.tpAPI.model.Question;

import java.util.List;

public interface ParticipationService {
    Participation creerParticipation(Participation participation);
    List<Participation> LireParticipation();
    Participation getParticipation(Long id, Participation participation);
    Participation modifierParticipation(Long id, Participation participation);
    String supprimerParticipation(Long id);
}
