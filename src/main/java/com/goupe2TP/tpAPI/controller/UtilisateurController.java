package com.goupe2TP.tpAPI.controller;

import com.goupe2TP.tpAPI.model.Utilisateur;
import com.goupe2TP.tpAPI.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    // LA METHODE CREATE
    @PostMapping("/create")
    public Utilisateur create(@RequestBody Utilisateur utilisateur){
        return utilisateurService.creer(utilisateur);
    }
    // LA METHODE READ
    @GetMapping("/read")
    public List<Utilisateur> read(){
        return utilisateurService.Lire();
    }

    // LA METHODE UPDATE
    @PutMapping("/update{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        return utilisateurService.modifier(id, utilisateur);
    }
    // LA METHODE DELETE
    @DeleteMapping("/delete")
    public String delete (@PathVariable Long id){
        return utilisateurService.supprimer(id);
    }



}
