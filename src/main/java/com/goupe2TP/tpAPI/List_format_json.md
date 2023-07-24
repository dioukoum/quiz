{
"titre": "html",
"utilisateur": 1,
"question": [
{
"text": "text de la question",
"reponse": [
{
"text": "reponse 1",
"iscorrect": false
},
{
"text": "reponse 2",
"iscorrect": false
},
{
"text": "reponse 3",
"iscorrect": true
}
]
}
]
}
package com.example.quiz.service;

import com.example.quiz.model.Quiz;
import com.example.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz updateQuizById(Long id, Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void deleteQuizById(Long id) {
        quizRepository.deleteById(id);
    }
}

package com.example.quiz.service;

import com.example.quiz.model.Utilisateur;
import com.example.quiz.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur updateUtilisateurById(Long id, Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateurById(Long id) {
        utilisateurRepository.deleteById(id);
    }
}

package com.example.quiz.service;

import com.example.quiz.model.Question;
import com.example.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestionById(Long id, Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
Sources
github.com/OrdinaNederland/quizapp
github.com/MatinParsapour/University
github.com/labrijisaad/ItilV4
wikidocs.net/160890
github.com/l3-miage-cl-ihm/projet-integrateur-2022-serveur-l3miage-gueissaesoumis à licence (MIT)
github.com/SteelIndustry/neo
github.com/AxelNordov/QBase
github.com/BlackEnergie/MC-Formation-Back
manualzz.com/doc/33563516/spring-boot-reference-guide-i.-spring-boot
github.com/CHOLVY-M1-Miage/projectBdiGroupe7ProdBack
github.com/kenmoejunior237/SoldLites
github.com/CodeMonk1602/Asgnmnt
github.com/YogenRaii/pdf
github.com/BogdanCinar/quizz
github.com/15rubles/microservicesPollsApp
Rechercher des thèmes associés
photo de profil
Et leurs controller


1

2

3

4
Bien sûr, voici les contrôleurs pour les modèles Quiz, Utilisateur, Question et Réponse :

package com.example.quiz.controller;

import com.example.quiz.model.Quiz;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.createQuiz(quiz);
        return new ResponseEntity<>(createdQuiz, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuizById(@PathVariable Long id, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.updateQuizById(id, quiz);
        return new ResponseEntity<>(updatedQuiz, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuizById(@PathVariable Long id) {
        quizService.deleteQuizById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
J'espère que cela vous aidera !

Sources
github.com/FutureIntent/quiz
www.javaguides.net/2022/06/spring-boot-apache-kafka-tutorial.html
github.com/luongvuc0622i1/Quar-Quizz-BE
github.com/alefilas/Web-Quiz-Engine
Rechercher des thèmes associés
photo de profil
Ok donne moi le format json pour créer un utilisateur, quiz, question , reponse
Afficher d'autres suggestions



















Bien sûr, voici les formats JSON pour créer un utilisateur, un quiz, une question et une réponse :

Utilisateur

{
"nom": "John Doe",
"prenom": "John",
"email": "johndoe@example.com",
"motDePasse": "password"
}
Quiz

{
"titre": "Quiz sur la France",
"description": "Ce quiz teste vos connaissances sur la France",
"questions": [
{
"texte": "Quelle est la capitale de la France ?",
"reponses": [
{
"texte": "Paris",
"correcte": true
},
{
"texte": "Lyon",
"correcte": false
},
{
"texte": "Marseille",
"correcte": false
}
]
},
{
"texte": "Quel est le drapeau de la France ?",
"reponses": [
{
"texte": "Un drapeau bleu, blanc et rouge",
"correcte": true
},
{
"texte": "Un drapeau blanc avec une fleur de lys",
"correcte": false
},
{
"texte": "Un drapeau noir avec un aigle blanc",
"correcte": false
}
]
}
]
}
Question

{
"texte": "Quelle est la capitale de la France ?",
"reponses": [
{
"texte": "Paris",
"correcte": true
},
{
"texte": "Lyon",
"correcte": false
},
{
"texte": "Marseille",
"correcte": false
}
]
}
Réponse

{
"texte": "Paris",
"correcte": true
}