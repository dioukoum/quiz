package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Entity.Reponse;
import com.goupe2TP.tpAPI.Repository.Repository_reponse;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Reponse_service {
private Repository_reponse repositoryReponse;
//constructeur avec param
public Reponse_service(Repository_reponse repositoryReponse){
    this.repositoryReponse = repositoryReponse;
}

    public void addReponse(Reponse reponse){
        repositoryReponse.save(reponse);
    }

    public List<Reponse> readReponse(){
    return repositoryReponse.findAll();
    }

    public String deleteReponse(int id){
    repositoryReponse.findById(id);
    return "delete succesful";
    }

    public Reponse updateReponse(Reponse reponse){
    return repositoryReponse.save(reponse);
    }

    public List<Reponse> getReponse(int id){
    return repositoryReponse.getReponseByQuestionsId(id);
    }
}
