package com.goupe2TP.tpAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;
@Valid
@Data
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Le nom ne doit pas être vide !")
    private String nom;

    @Column(nullable = false , length = 100)
    @NotBlank(message = "Le prenom ne doit pas être vide !")
    private String prenom;

    @Column(nullable = false)
    @Min(value = 18, message = "L'âge doit être supperieur ou égale à 18")
    private int age;

    @Column(nullable = false, length = 225)
    @NotBlank(message = "Le nom est ne doit pas être vide !")
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
    @NotBlank(message = "L'email ne doit pas être vide !")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Le mot de pass est obligatoire  !")
    @Length(max = 6, message = "Mot de passe doit être au moins 6  carractère !")
    @Length(max = 8, message = "Mot de passe ne doit dépasser 8  carractère !")
    private String motDePass;

}
