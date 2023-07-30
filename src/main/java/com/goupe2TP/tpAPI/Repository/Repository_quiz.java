package com.goupe2TP.tpAPI.Repository;

import com.goupe2TP.tpAPI.Entity.Participants;
import com.goupe2TP.tpAPI.Entity.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repository_quiz extends CrudRepository<Quiz, Integer> {
    //methode delete
    Quiz findById(int id);

    //methode get
    List<Quiz> findAll();


}
