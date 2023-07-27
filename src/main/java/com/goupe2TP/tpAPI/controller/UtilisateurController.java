package com.goupe2TP.tpAPI.controller;

import com.goupe2TP.tpAPI.controller.controllerAdvice.ControllerAdviceConfig;
import com.goupe2TP.tpAPI.model.Utilisateur;
import com.goupe2TP.tpAPI.service.UtilisateurService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
    @Operation(summary = "Crée un nouveau utilisateur")
    public Utilisateur create(@Valid @RequestBody Utilisateur utilisateur){
        return utilisateurService.creer(utilisateur);
    }
    // LA METHODE READ
    @GetMapping("/read")
    @Operation(summary = "Afficher la liste utilisateur")
    public List<Utilisateur> read(){
        return utilisateurService.Lire();
    }

    @GetMapping("/read/{id}")
    @Operation(summary = "Afficher un utilisateur par son ID")
    public Utilisateur read(@PathVariable Long id,@Valid @RequestBody Utilisateur utilisateur){
        return utilisateurService.getUser(id, utilisateur);
    }

    // LA METHODE UPDATE
    @Operation(summary = "Récupère un produit grâce à son ID à condition que celui-ci soit en stock!")
    @PutMapping("/update/{id}")
    //@ApiOperation("Modifier un utilisateur par son ID")
    public Utilisateur update(@PathVariable Long id,@Valid @RequestBody Utilisateur utilisateur){
        return utilisateurService.modifier(id, utilisateur);
    }
    // LA METHODE DELETE
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer un utilisateur par son ID")
    public String delete (@PathVariable Long id){

        return utilisateurService.supprimer(id);
    }



}
