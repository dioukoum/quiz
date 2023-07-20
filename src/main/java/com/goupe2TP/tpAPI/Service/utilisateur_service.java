package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Entity.utilisateur;
import com.goupe2TP.tpAPI.Repository.Repository_utilisateur;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Data
@Service
public class utilisateur_service {

    @Autowired
    private Repository_utilisateur repositoryUtilisateur;

    public void addUser(utilisateur user){
        repositoryUtilisateur.save(user);
    }
    public utilisateur update(utilisateur user){
        repositoryUtilisateur.save(user);
        return repositoryUtilisateur.findById(user.getId());
    }
    public void deleteUtilisateur(int id){
        repositoryUtilisateur.deleteById(id);
    }
    public List<utilisateur> getUsers(){
        return repositoryUtilisateur.findAll();
    }

}
