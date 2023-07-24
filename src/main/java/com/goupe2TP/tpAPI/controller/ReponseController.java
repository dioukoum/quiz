package com.goupe2TP.tpAPI.controller;
import com.goupe2TP.tpAPI.model.Reponse;
import com.goupe2TP.tpAPI.service.ReponseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reponse")
public class ReponseController {

    private final ReponseService reponseService;

    public ReponseController(ReponseService reponseService) {
        this.reponseService = reponseService;
    }

    // LA METHODE CREATE
    @PostMapping("/create")
    public Reponse create(@RequestBody Reponse reponse){
        return reponseService.creerReponse(reponse);
    }

    // LA METHODE READ
    @GetMapping("/read")
    public List<Reponse> read(){
        return reponseService.LireReponse();
    }
    @GetMapping("/read/{id}")
    public Reponse read(@PathVariable Long id, @RequestBody Reponse reponse){
        return reponseService.getReponse(id, reponse);
    }

    // LA METHODE UPDATE
    @PutMapping("/update/{id}")
    public Reponse update(@PathVariable Long id, @RequestBody Reponse reponse){
        return reponseService.modifierReponse(id, reponse);
    }
    // LA METHODE DELETE
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        return reponseService.supprimerReponse(id);
    }



}
