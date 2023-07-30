package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Entity.*;
import com.goupe2TP.tpAPI.Repository.Repository_participant;
import com.goupe2TP.tpAPI.Repository.Repository_quiz;
import com.goupe2TP.tpAPI.Repository.Repository_utilisateur;
import jakarta.persistence.SecondaryTable;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Data
public class Quiz_service {
    @Autowired
    private Repository_quiz repositoryQuiz;
    @Autowired
    private Repository_utilisateur repositoryUtilisateur;

    @Autowired
    private Repository_participant repositoryParticipant;

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


    public Quiz getQuiz(int id){
        return repositoryQuiz.findById(id);
    }

    //methode selection
    public Quiz addQuizUser(int id, Quiz quiz) {
        utilisateur user = repositoryUtilisateur.findById(id);
        quiz.setUtilisateur(user);
        return repositoryQuiz.save(quiz);
    }

    public Quiz select(int id){
        return repositoryQuiz.findById(id);
    }


    //=====================================jouer==================================


    public List<String> quizParticipe(){
        List<String> list = new ArrayList<>();
        List<Quiz> quizList = repositoryQuiz.findAll();
        list.add("choisie une quiz pour commencer");
        quizList.forEach(quiz -> {
            list.add(list.size()+" : "+quiz.getTitre());
        });
        return list;
    }

    public List<String> ready(int idUser, int idQuiz){
        Participants participants = repositoryParticipant.findByIdUtilisateurIdAndIdQuizId(idUser,idQuiz);
        if(participants == null){
            Participants participants1 = new Participants();
            participants1.setIdUtilisateur(repositoryUtilisateur.findById(idUser));
            participants1.setIdQuiz(repositoryQuiz.findById(repositoryQuiz.findAll().get(idQuiz-1).getId()));
            participants1.setScore(0);
            participants1.setNiveau(1);
            repositoryParticipant.save(participants1);
            Questions questions = repositoryQuiz.findById(repositoryQuiz.findAll().get(idQuiz-1).getId()).getQuestions().get(0);
            List<String> stringList = new ArrayList<>();
            stringList.add("choisissez une reponse ");
            stringList.add(questions.getText());
            stringList.add("");
            questions.getReponses().forEach(reponse -> {
                stringList.add(stringList.size()-2+" : "+reponse.getText());
            });
            return stringList;

        }else{
            Questions questionss = repositoryQuiz.findById(repositoryQuiz.findAll().get(idQuiz-1).getId()).getQuestions().get(participants.getNiveau()-1);
            List<String> liste = new ArrayList<>();
            liste.add("choisissez une reponse ");
            liste.add(questionss.getText());
            liste.add("");
            questionss.getReponses().forEach(reponse -> {
                liste.add(liste.size()-2+" : "+reponse.getText());
            });
            return liste;
        }
    }

    public List<String> reponse(int idUser, int idQuiz, int choix){
        Participants participants = repositoryParticipant.findByIdUtilisateurIdAndIdQuizId(idUser,idQuiz);
        Questions questions = repositoryQuiz.findById(repositoryQuiz.findAll().get(idQuiz-1).getId()).getQuestions().get(participants.getNiveau()-1);
        Reponse reponse = questions.getReponses().get(choix-1);
        List<String> listreponse = new ArrayList<>();
        if(reponse.getCorrecte().equals("ok")){
            List<Questions> questions1 = repositoryQuiz.findById(repositoryQuiz.findAll().get(idQuiz-1).getId()).getQuestions();
            if(questions1.size()>=participants.getNiveau()+1){
                participants.setScore(participants.getScore()+10);
                participants.setNiveau(participants.getNiveau()+1);
                repositoryParticipant.save(participants);
                questions = repositoryQuiz.findById(repositoryQuiz.findAll().get(idQuiz-1).getId()).getQuestions().get(participants.getNiveau()-1);
                listreponse.add("bonne reponse passer au suivant, votre score est "+participants.getScore()+"points");
                listreponse.add(questions.getText());
                listreponse.add("");
                questions.getReponses().forEach(reponse1 -> {
                    listreponse.add(listreponse.size()-2+" : "+reponse1.getText());
                });
                return listreponse;
            }else {
                participants.setScore(participants.getScore()+10);
                repositoryParticipant.save(participants);
                listreponse.add("bonne reponse passer au suivant, votre score est "+participants.getScore()+"points");
                listreponse.add("jeux terminé,votre score est "+participants.getScore());
                return listreponse;
            }
        }else{
            List<Questions> questions1 = repositoryQuiz.findById(repositoryQuiz.findAll().get(idQuiz-1).getId()).getQuestions();
            if(questions1.size()>=participants.getNiveau()+1){
                participants.setNiveau(participants.getNiveau()+1);
                repositoryParticipant.save(participants);
                Questions questions2 = repositoryQuiz.findById(repositoryQuiz.findAll().get(idQuiz-1).getId()).getQuestions().get(participants.getNiveau()-1);
                questions.getReponses().forEach(reponse1 -> {
                    if(reponse1.getCorrecte().equals("ok")){
                        listreponse.add("mauvaise reponse, la bonne reponse etait "+reponse1.getText());
                    }
                });
                listreponse.add("au suivant");
                listreponse.add(questions2.getText());
                listreponse.add("");
                questions2.getReponses().forEach(reponse1 -> {
                    listreponse.add(listreponse.size()-3+" : "+reponse.getText());
                });
                return listreponse;
            }else {
                questions.getReponses().forEach(reponse1 -> {
                    if(reponse1.getCorrecte().equals("ok")){
                        listreponse.add("mauvaise reponse, la bonne reponse etait "+reponse1.getText());
                    }
                });
                listreponse.add("jeux terminé, votre score final est"+reponse);
                return listreponse;
            }
        }
    }

}
