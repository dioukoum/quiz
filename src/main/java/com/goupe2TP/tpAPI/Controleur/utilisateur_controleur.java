package com.goupe2TP.tpAPI.Controleur;

import com.goupe2TP.tpAPI.Entity.utilisateur;
import com.goupe2TP.tpAPI.Service.utilisateur_service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class utilisateur_controleur {

    @Autowired
    private utilisateur_service utilisateurService;

    @GetMapping("/connexion")
    public Object utilisateur(@RequestParam("email") String email, @RequestParam("motDePasse") String motDePasse){
       utilisateur verification = utilisateurService.connexion(email, motDePasse);
        if (verification != null){
            return verification;
        }else{
            return "cet utilisateur n'existe pas";
        }
    }
    @PostMapping("/ajouter")
    public String access(@Valid @RequestBody utilisateur user){
        utilisateurService.addUser(user);
        return  "ajout avec succès";
    }

    @GetMapping("/read")
    public List<utilisateur> read(){
       return utilisateurService.read();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        utilisateurService.delete(id);
        return "delete succes";
    }

    @PutMapping("/put")
    public utilisateur put(@RequestBody utilisateur user){
        return utilisateurService.update(user);
    }

}
