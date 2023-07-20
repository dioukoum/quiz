package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Repository.Repository_quiz;
import org.springframework.stereotype.Service;

@Service
public class Quiz_service {
    private Repository_quiz repositoryQuiz;
    //constructeur avec param
    public Quiz_service(Repository_quiz repositoryQuiz){
        this.repositoryQuiz = repositoryQuiz;
    }
}
