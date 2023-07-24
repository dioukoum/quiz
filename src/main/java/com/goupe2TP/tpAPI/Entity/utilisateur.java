package com.goupe2TP.tpAPI.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.util.List;

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

    @Pattern(regexp = "^[a-z-A-Z]")
    @Column(nullable = false)
    private String motDePasse;

    @Column(nullable = false)
    private  int age;

   @OneToMany
            (       mappedBy = "utilisateur",
                    cascade = CascadeType.ALL
            )
    @Column(nullable = false)
    @JsonIgnoreProperties("utilisateur")
    private List<Quiz> quizList;

}
