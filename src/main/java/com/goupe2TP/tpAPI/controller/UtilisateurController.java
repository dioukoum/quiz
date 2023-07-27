package com.goupe2TP.tpAPI.controller;

import com.goupe2TP.tpAPI.controller.controllerAdvice.ControllerAdviceConfig;
import com.goupe2TP.tpAPI.model.Utilisateur;
import com.goupe2TP.tpAPI.service.UtilisateurService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@ApiOperation("Acceder à la page utilisateur")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    // LA METHODE CREATE
    @PostMapping("/create")
    @ApiOperation("Crée un nouveau utilisateur")
    public Utilisateur create(@RequestBody Utilisateur utilisateur){
        return utilisateurService.creer(utilisateur);
    }
    // LA METHODE READ
    @GetMapping("/read")
    @ApiOperation("Afficher la liste utilisateur")
    public List<Utilisateur> read(){
        return utilisateurService.Lire();
    }

    @GetMapping("/read/{id}")
    @ApiOperation("Afficher un utilisateur par son ID")
    public Utilisateur read(@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        return utilisateurService.getUser(id, utilisateur);
    }

    // LA METHODE UPDATE
    @PutMapping("/update/{id}")
    @ApiOperation("Modifier un utilisateur par son ID")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        return utilisateurService.modifier(id, utilisateur);
    }
    // LA METHODE DELETE
    @DeleteMapping("/delete/{id}")
    @ApiOperation("Supprimer un utilisateur par son ID")
    public String delete (@PathVariable Long id){

        return utilisateurService.supprimer(id);
    }



}
