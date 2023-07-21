package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Quiz;


import java.util.List;

public interface QuizService {
    Quiz creer(Quiz quiz);
    List<Quiz> Lire();
    Quiz modifier(Long id, Quiz quiz);
    String supprimer(Long id);
}
