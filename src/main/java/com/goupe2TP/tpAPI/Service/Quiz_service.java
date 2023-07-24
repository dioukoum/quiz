package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Entity.Quiz;
import com.goupe2TP.tpAPI.Entity.utilisateur;
import com.goupe2TP.tpAPI.Repository.Repository_quiz;
import com.goupe2TP.tpAPI.Repository.Repository_utilisateur;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class Quiz_service {
    private Repository_quiz repositoryQuiz;
    private Repository_utilisateur repositoryUtilisateur;
    //constructeur avec param
    public Quiz_service(Repository_quiz repositoryQuiz){
        this.repositoryQuiz = repositoryQuiz;
    }

    public void addQuiz(Quiz quiz) {
        repositoryQuiz.save(quiz);
    }

    public Quiz updateQuiz(Quiz quiz){
        repositoryQuiz.save(quiz);
        return repositoryQuiz.findById(quiz.getId());
    }

    public void delete(int id)
    {
        repositoryQuiz.findById(id);
    }

    public List<Quiz> readQuiz(){
       return  repositoryQuiz.findAll();
    }

    //methode selection
    public Quiz addQuizUser(int id, Quiz quiz){
        utilisateur user = repositoryUtilisateur.findById(id);

        quiz.setUtilisateur(user);
        return repositoryQuiz.save(quiz);
    }
}
