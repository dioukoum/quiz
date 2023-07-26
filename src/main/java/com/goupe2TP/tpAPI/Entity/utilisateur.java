package com.goupe2TP.tpAPI.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Utilisateur")
public class utilisateur {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private  String email;

    @Column(nullable = false)
    private String motDePasse;

    @Column(nullable = false)
    private  int age;

  @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL)
   @Column(nullable = false)
   @JsonIgnoreProperties("utilisateur")
    private List<Quiz> quizCreer;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "idUtilisateur")
    @JsonIgnore
    private List<Participants> participants;


}
