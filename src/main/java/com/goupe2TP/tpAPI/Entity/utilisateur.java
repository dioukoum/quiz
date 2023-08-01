package com.goupe2TP.tpAPI.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "le champ ne doit pas etre vide")
    @Column(nullable = false)
    private String nom;

    @NotBlank(message = "le champ ne doit pas etre vide")
    @Column(nullable = false)
    private String prenom;

    @Email(message = "address mail invalide")
    @Column(nullable = false, unique = true)
    private  String email;

    @Pattern(regexp = "^\\d{8}$", message = "numero incorrect")
    private String tel;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "votre message est incorrecte")
    @Column(nullable = false)
    private String motDePasse;

    @Min(value = 18,message = "votre age doit être supperieur a 18 ans")
    @Max(value = 60, message = "votre age doit être inferieur a 60 ans ")
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
