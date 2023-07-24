package com.goupe2TP.tpAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity

public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> question;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Utilisateur utilisateur;

}
