package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Quiz;
import com.goupe2TP.tpAPI.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{
    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz creer(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> Lire() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz modifier(Long id, Quiz quiz) {
        return quizRepository.findById(id).map(q ->{

            q.setTitre(quiz.getTitre());

            return quizRepository.save(q);
        }).orElseThrow(()-> new RuntimeException("Quiz non trouvé !"));
    }

    @Override
    public String supprimer(Long id) {
        quizRepository.deleteById(id);
        return "Quiz supprimer avec succès !";
    }
}
