package com.goupe2TP.tpAPI.Repository;

import com.goupe2TP.tpAPI.Entity.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repository_question extends CrudRepository<Questions, Integer> {
    List<Questions> findAll();
}
