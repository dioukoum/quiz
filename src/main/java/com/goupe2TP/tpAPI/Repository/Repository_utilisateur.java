package com.goupe2TP.tpAPI.Repository;

import com.goupe2TP.tpAPI.Entity.utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repository_utilisateur extends CrudRepository<utilisateur,Integer> {
public utilisateur findById(int id);
utilisateur findByEmail(String email);
public List<utilisateur> findAll();


    utilisateur findByEmailAndMotDePasse(String email, String motDePasse);
}
