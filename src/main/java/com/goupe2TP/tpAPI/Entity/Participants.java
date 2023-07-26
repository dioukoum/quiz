package com.goupe2TP.tpAPI.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Participants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private utilisateur idUtilisateur;

    @ManyToOne
    private Quiz idQuiz;

    @Column(nullable = false)
    private int score;

}
