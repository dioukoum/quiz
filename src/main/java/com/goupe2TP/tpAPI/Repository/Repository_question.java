package com.goupe2TP.tpAPI.Repository;

import com.goupe2TP.tpAPI.Entity.Questions;
import com.goupe2TP.tpAPI.Entity.Quiz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Repository_question extends CrudRepository<Questions, Integer> {
    List<Questions> findAll();

   List<Questions> findByQuizId(int quiId);


   /* @Query("SELECT q FROM Questions q WHERE q.id = :questionId AND q.quiz.id = :quizId")
    Questions findByIdAndQuizId(@Param("questionId") int questionId, @Param("quizId") int quizId);*/

    List<Questions> findQuestionsByQuizId(int id);
}

