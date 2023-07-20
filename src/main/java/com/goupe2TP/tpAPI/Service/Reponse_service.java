package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Repository.Repository_reponse;
import org.springframework.stereotype.Service;

@Service
public class Reponse_service {
private Repository_reponse repositoryReponse;
//constructeur avec param
public Reponse_service(Repository_reponse repositoryReponse){
    this.repositoryReponse = repositoryReponse;
}
}
