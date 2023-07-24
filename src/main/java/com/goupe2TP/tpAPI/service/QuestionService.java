package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Question;

import java.util.List;

public interface QuestionService {
    Question creerQuestion(Question question);
    List<Question> LireQuestion();
    Question getQuest(Long id, Question question);
    Question modifierQuestion(Long id, Question question);
    String supprimerQuestion(Long id);
}
