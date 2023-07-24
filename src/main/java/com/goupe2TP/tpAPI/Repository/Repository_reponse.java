package com.goupe2TP.tpAPI.Repository;

import com.goupe2TP.tpAPI.Entity.Reponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repository_reponse extends CrudRepository<Reponse, Integer> {
    List<Reponse> findAll();
}
