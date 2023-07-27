package com.goupe2TP.tpAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;
@Data

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nom;
    @Column(nullable = false , length = 100)
    private String prenom;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false, length = 225)
    private String telephone;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JsonIgnoreProperties("utilisateur")
    private List<Participation> participation;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JsonIgnoreProperties("utilisateur")
    private List<Quiz> quiz;

    @Column(nullable = false, unique = true)
    @Email(message = "Email doit être un format valide !")
    private String email;

    @Column(nullable = false)
    private String motDePass;

}
