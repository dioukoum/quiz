package com.goupe2TP.tpAPI.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "question")
public class Questions {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn (name = "quiz_id", nullable = false)
    private Quiz quiz;


    @OneToMany
            (mappedBy = "questions", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("questions")
    @Column(nullable = false)
    private List<Reponse> reponses;

    @JsonIgnore
    public List<Reponse> getReponses() {
        return reponses;
    }
}
