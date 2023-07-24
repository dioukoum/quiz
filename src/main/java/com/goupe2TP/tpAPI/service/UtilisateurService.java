package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur creer(Utilisateur utilisateur);
    List<Utilisateur> Lire();
    Utilisateur getUser(Long id, Utilisateur utilisateur);

    Utilisateur modifier(Long id, Utilisateur utilisateur);
    String supprimer(Long id);
}
