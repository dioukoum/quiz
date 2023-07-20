package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Repository.Repository_question;
import org.springframework.stereotype.Service;

@Service
public class Questions_service {
    private Repository_question repositoryQuestion;
    //constructeur
    public Questions_service(Repository_question repositoryQuestion){
        this.repositoryQuestion = repositoryQuestion;
    }
}
