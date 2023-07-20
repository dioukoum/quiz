package com.goupe2TP.tpAPI.Entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "Utilisateur")
public class utilisateur {
    @Id
    @Column(name = "utilisateur_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "utilisateur_nom")
    private String Nom;

    @Column(name = "utilisateur_prenom")
    private String Prenom;

    @Column(name = "utilisateur_email")
    private  String Email;

    @Column(name = "utilisateur_age")
    private  int Age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
