package com.goupe2TP.tpAPI.service;
import com.goupe2TP.tpAPI.model.Reponse;

import java.util.List;

public interface ReponseService {
    Reponse creerReponse(Reponse reponse);
    List<Reponse> LireReponse();
    Reponse getReponse(Long id, Reponse reponse);
    Reponse modifierReponse(Long id, Reponse reponse);
    String supprimerReponse(Long id);
}
