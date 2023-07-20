package com.goupe2TP.tpAPI.Entity;

import jakarta.persistence.*;

@Entity
public class Test {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTest;

    private String content;
}
