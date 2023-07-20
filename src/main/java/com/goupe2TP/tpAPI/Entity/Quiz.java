package com.goupe2TP.tpAPI.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Quiz_id")
    private int id;

    @Column(name = "Quiz_titre")
    private String Titre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }
}
