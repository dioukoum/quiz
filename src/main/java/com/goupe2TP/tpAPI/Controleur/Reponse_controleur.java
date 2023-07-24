package com.goupe2TP.tpAPI.Controleur;

import com.goupe2TP.tpAPI.Entity.Reponse;
import com.goupe2TP.tpAPI.Service.Reponse_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reponse")
public class Reponse_controleur {

    @Autowired
    private Reponse_service reponseService;

    @PostMapping("/addReponse")
    public String addReponse(@RequestBody Reponse reponse){
        reponseService.addReponse(reponse);
        return "add response successful";
    }

    @GetMapping("/readReponse")
    public List<Reponse> readReponse(){
        return reponseService.readReponse();
    }

    @DeleteMapping("/deleteReponse/{id}")
    public ResponseEntity<String> deleteReponse(@PathVariable int id){
        reponseService.deleteReponse(id);
        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }

    @PutMapping("updateReponse")
    public Reponse updateReponse(@RequestBody Reponse reponse){
        return reponseService.updateReponse(reponse);
    }
}
