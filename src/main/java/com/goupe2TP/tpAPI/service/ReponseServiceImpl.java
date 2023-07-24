package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Reponse;
import com.goupe2TP.tpAPI.repository.ReponseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service
public class ReponseServiceImpl implements ReponseService{
    @Autowired
    private final ReponseRepository reponseRepository;

    @Override
    public Reponse creerReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    @Override
    public List<Reponse> LireReponse() {
        return reponseRepository.findAll();
    }

    @Override
    public Reponse getReponse(Long id, Reponse reponse) {
        return reponseRepository.findById(id).orElseThrow(()-> new RuntimeException("Reponse non trouvé !"));
    }

    @Override
    public Reponse modifierReponse(Long id, Reponse reponse) {
        return reponseRepository.findById(id).map(r ->{

            r.setText(reponse.getText());
            r.setQuestion(reponse.getQuestion());
            r.setIscorrect(reponse.getIscorrect());
            return reponseRepository.save(r);
        }).orElseThrow(()-> new RuntimeException("Reponse non trouvé !"));
    }

    @Override
    public String supprimerReponse(Long id) {
        reponseRepository.deleteById(id);
        return "Reponse supprimer avec succès !";
    }
}
