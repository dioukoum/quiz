package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Entity.Quiz;
import com.goupe2TP.tpAPI.Entity.utilisateur;
import com.goupe2TP.tpAPI.Repository.Repository_quiz;
import com.goupe2TP.tpAPI.Repository.Repository_utilisateur;
import jakarta.persistence.SecondaryTable;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Data
public class Quiz_service {
    private Repository_quiz repositoryQuiz;
    private Repository_utilisateur repositoryUtilisateur;

    //constructeur avec param
    public Quiz_service(Repository_quiz repositoryQuiz) {
        this.repositoryQuiz = repositoryQuiz;
    }

    public void addQuiz(Quiz quiz) {
        repositoryQuiz.save(quiz);
    }

    public Quiz updateQuiz(Quiz quiz) {
        repositoryQuiz.save(quiz);
        return repositoryQuiz.findById(quiz.getId());
    }

    public void delete(int id) {
        repositoryQuiz.findById(id);
    }

    public List<Quiz> readQuiz() {
        return repositoryQuiz.findAll();
    }

    //methode selection
    public Quiz addQuizUser(int id, Quiz quiz) {
        utilisateur user = repositoryUtilisateur.findById(id);
        quiz.setUtilisateur(user);
        return repositoryQuiz.save(quiz);
    }

   /* public Set<utilisateur> getUsersByQuizId(Long quizId) {
        Quiz quiz = repositoryQuiz.findById(Math.toIntExact(quizId));
        if (quiz != null) {
            return quiz.getUtilisateurSet();
        }
        return new HashSet<>();
    }


    public boolean addParticipantToQuiz(Long quizId, utilisateur participant) {
        Quiz quiz = repositoryQuiz.findById(Math.toIntExact(quizId));
        if (quiz != null) {
            quiz.getUtilisateurSet().add(participant);
            repositoryQuiz.save(quiz);
            return true;
        }
        return false;
    }


    public Set<utilisateur> getAllParticipants() {
        Set<utilisateur> allParticipants = new HashSet<>();
        List<Quiz> allQuizzes = repositoryQuiz.findAll();
        for (Quiz quiz : allQuizzes) {
            allParticipants.addAll(quiz.getUtilisateurSet());
        }
        return allParticipants;
    }*/

    public
}
