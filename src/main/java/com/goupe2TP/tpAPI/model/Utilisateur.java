package com.goupe2TP.tpAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
    private List<Quiz> quiz;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String motDePass;

}
