package com.goupe2TP.tpAPI.repository;

import com.goupe2TP.tpAPI.model.Quiz;
import com.goupe2TP.tpAPI.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
