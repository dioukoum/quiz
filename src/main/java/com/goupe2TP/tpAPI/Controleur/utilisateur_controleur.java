package com.goupe2TP.tpAPI.Controleur;

import com.goupe2TP.tpAPI.Entity.utilisateur;
import com.goupe2TP.tpAPI.Service.utilisateur_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class utilisateur_controleur {

    @Autowired
    private utilisateur_service utilisateurService;

    @PostMapping("/utilisateur")
    public String access(@RequestBody utilisateur user){
        utilisateurService.addUser(user);
        return "gcghvjb";
    }


}
