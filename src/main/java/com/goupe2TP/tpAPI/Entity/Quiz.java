package com.goupe2TP.tpAPI.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String titre;



    @ManyToOne
    @JoinColumn(name = "utilisateur_id",nullable = false)
    //@JsonIgnore
    private utilisateur utilisateur;

    @OneToMany
            (mappedBy = "quiz", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("quiz")
    @Column(nullable = false)
    private List<Questions> questions;

}
