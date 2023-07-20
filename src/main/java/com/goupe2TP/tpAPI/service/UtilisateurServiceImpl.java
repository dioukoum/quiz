package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Utilisateur;
import com.goupe2TP.tpAPI.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UtilisateurServiceImpl implements UtilisateurService{
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateur creer(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> Lire() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur modifier(Long id, Utilisateur utilisateur) {


       return utilisateurRepository.findById(id).map(u ->{

            u.setNom(utilisateur.getNom());
            u.setPrenom(utilisateur.getPrenom());
            u.setAge(utilisateur.getAge());
            u.setTelephone(utilisateur.getTelephone());
            u.setEmail(utilisateur.getEmail());
            return utilisateurRepository.save(u);
        }).orElseThrow(()-> new RuntimeException("Utilisateur non trouvé !"));
    }

    @Override
    public String supprimer(Long id) {
        utilisateurRepository.deleteById(id);
        return "Utilisateur supprimer avec succès !";
    }
}
