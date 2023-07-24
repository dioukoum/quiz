package com.goupe2TP.tpAPI.Entity;
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
    private Questions questions;

}

