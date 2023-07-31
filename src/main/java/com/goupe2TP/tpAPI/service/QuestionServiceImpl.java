package com.goupe2TP.tpAPI.service;

import com.goupe2TP.tpAPI.model.Question;
import com.goupe2TP.tpAPI.repository.QuestionRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class QuestionServiceImpl implements QuestionService{
    private final QuestionRepository questionRepository;


    @Override
    public Question creerQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> LireQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuest(Long id, Question question) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question non trouvé !"));
    }

    @Override
    public Question modifierQuestion(Long id, Question question) {
        return questionRepository.findById(id).map(q ->{

            q.setText(question.getText());
            q.setQuiz(question.getQuiz());

            return questionRepository.save(q);
        }).orElseThrow(()-> new RuntimeException("Question non trouvé !"));
    }

    @Override
    public String supprimerQuestion(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question non trouvé !"));

        if (question != null ){
            questionRepository.deleteById(question.getId());
            return "Question supprimer avec succès !";
        }
        if (question == null){
            return "Question non trouvé !";
        }
        return null;
    }
}
