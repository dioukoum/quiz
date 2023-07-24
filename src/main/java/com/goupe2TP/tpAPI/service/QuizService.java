package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Quiz;



import java.util.List;


public interface QuizService {
    Quiz creerQuiz(Quiz quiz);
    List<Quiz> LireQuiz();
    Quiz getUser(Long id, Quiz quiz);
    Quiz modifierQuiz(Long id, Quiz quiz);
    String supprimerQuiz(Long id);
}
