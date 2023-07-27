package com.goupe2TP.tpAPI.controller;

import com.goupe2TP.tpAPI.model.Participation;
import com.goupe2TP.tpAPI.model.Utilisateur;
import com.goupe2TP.tpAPI.service.ParticipationService;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/participation")
public class ParticipationController {
    @Autowired
    private final ParticipationService participationService;

    // LA METHODE CREATE
    @PostMapping("/create")
    @ApiOperation("Crée une nouvelle participation")
    public Participation create(@RequestBody Participation participation){
        return participationService.creerParticipation(participation);
    }
    // LA METHODE READ
    @GetMapping("/read")
    @ApiOperation("Afficher la liste participation")
    public List<Participation> read(){
        return participationService.LireParticipation();
    }

    @GetMapping("/read/{id}")
    @ApiOperation("Afficher une participation par son ID")
    public Participation read(@PathVariable Long id, @RequestBody Participation participation){
        return participationService.getParticipation(id, participation);
    }

    // LA METHODE UPDATE
    @PutMapping("/update/{id}")
    @ApiOperation("Modifier une participation par son ID")
    public Participation update(@PathVariable Long id, @RequestBody Participation participation){
        return participationService.modifierParticipation(id, participation);
    }
    // LA METHODE DELETE
    @DeleteMapping("/delete/{id}")
    @ApiOperation("Supprimer une participation par son ID")
    public String delete (@PathVariable Long id){
        return participationService.supprimerParticipation(id);
    }

}
