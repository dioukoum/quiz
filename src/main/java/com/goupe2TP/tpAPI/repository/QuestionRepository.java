package com.goupe2TP.tpAPI.repository;

import com.goupe2TP.tpAPI.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository <Question, Long> {

}
