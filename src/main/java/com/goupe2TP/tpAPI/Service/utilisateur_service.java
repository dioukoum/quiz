package com.goupe2TP.tpAPI.Service;

import com.goupe2TP.tpAPI.Entity.utilisateur;
import com.goupe2TP.tpAPI.Entity.utilisateurAlreadyExistsException;
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

    public String addUser(utilisateur user) throws utilisateurAlreadyExistsException
    {
       utilisateur utilisateurExiste = repositoryUtilisateur.findById(user.getId());
       if(utilisateurExiste == null) {
           repositoryUtilisateur.save(user);
           return "ajout avec succes";
       }else {
           throw new utilisateurAlreadyExistsException("utilisateur existe");
       }
    }

    public utilisateur update(utilisateur user){
        repositoryUtilisateur.save(user);
        return repositoryUtilisateur.findById(user.getId());
    }
    public void delete(int id){
        repositoryUtilisateur.deleteById(id);
    }

    public List<utilisateur> read(){
        return repositoryUtilisateur.findAll();
    }

    public utilisateur read(int id){
       return  repositoryUtilisateur.findById(id);
    }

    public utilisateur put(utilisateur user) {
        return repositoryUtilisateur.save(user);
    }

    //methode de connexion
    public utilisateur connexion(String email, String motDePasse){
        repositoryUtilisateur.findByEmailAndMotDePasse( email, motDePasse);
        if (repositoryUtilisateur.findByEmailAndMotDePasse(email, motDePasse) != null) {
            return repositoryUtilisateur.findByEmailAndMotDePasse(email,motDePasse);
        } else {
            return null;
        }
    }
}