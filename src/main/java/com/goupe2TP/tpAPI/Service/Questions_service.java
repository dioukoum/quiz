package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Entity.Questions;
import com.goupe2TP.tpAPI.Entity.Quiz;
import com.goupe2TP.tpAPI.Repository.Repository_question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Questions_service {
    private Repository_question repositoryQuestion;
    //constructeur
    public Questions_service(Repository_question repositoryQuestion){
        this.repositoryQuestion = repositoryQuestion;
    }

    public void createQuestion(Questions questions){
        repositoryQuestion.save(questions);
    }

    public List<Questions> readQuestion(){
        return repositoryQuestion.findAll();

    }

    public void deleteQuestion(int id){
        repositoryQuestion.deleteById(id);
    }

    public Questions updateQuestion(Questions questions){
       return repositoryQuestion.save(questions);
    }

    /*public Questions slectQuestion(int questionId, int quizId) {
        return repositoryQuestion.findByIdAndQuizId(questionId, quizId);
    }*/

    public List<Questions> getQuestion(int id) {

        return repositoryQuestion.findQuestionsByQuizId(id);
    }



}
