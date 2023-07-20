package com.goupe2TP.tpAPI.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Reponse")
public class Reponse {
    @Id
    @Column(name = "reponse_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "reponse_text")
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

