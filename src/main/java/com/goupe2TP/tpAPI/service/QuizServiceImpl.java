package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Quiz;
import com.goupe2TP.tpAPI.repository.QuizRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class QuizServiceImpl implements QuizService{
    private final QuizRepository quizRepository;



    @Autowired


    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz creerQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> LireQuiz() {
        return quizRepository.findAll();
    }
    @Override
    public Quiz getUser(Long id, Quiz quiz){
        return quizRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Quiz non trouvé !"));

    }

    @Override
    public Quiz modifierQuiz(Long id, Quiz quiz) {
        return quizRepository.findById(id).map(q ->{

            q.setTitre(quiz.getTitre());
            q.setUtilisateur(quiz.getUtilisateur());

            return quizRepository.save(q);
        }).orElseThrow(()-> new RuntimeException("Quiz non trouvé !"));
    }

    @Override
    public String supprimerQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz non trouvé !"));

        if (quiz != null ){
            quizRepository.deleteById(quiz.getId());
            return "Quiz supprimer avec succès !";
        }
        if (quiz == null){
            return "Quiz non trouvé !";
        }
        return null;
    }
}
