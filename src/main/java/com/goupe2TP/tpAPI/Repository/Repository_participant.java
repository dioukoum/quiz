package com.goupe2TP.tpAPI.Repository;

import com.goupe2TP.tpAPI.Entity.Participants;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repository_participant extends CrudRepository<Participants, Integer> {
    List<Participants> findAll();

}
