package com.goupe2TP.tpAPI.Controleur;

import com.goupe2TP.tpAPI.Entity.Participants;
import com.goupe2TP.tpAPI.Service.Participant_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participer")
public class Participant_contriller {

    @Autowired
    private Participant_service participantService;

    @PostMapping("/add")
    public String add(@RequestBody Participants participants){
        return participantService.addParticipant(participants);
    }

    @GetMapping("/read")
    public List<Participants> read(){
        return participantService.getParticipant();
    }
}
