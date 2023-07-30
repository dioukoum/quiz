package com.goupe2TP.tpAPI.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Reponse")
public class Reponse {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id",nullable = false)
    @JsonIgnoreProperties("quiz")
    private Questions questions;

    @Column(nullable = false)
    private String correcte;

}

