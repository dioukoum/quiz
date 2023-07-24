package com.goupe2TP.tpAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JsonIgnoreProperties("quiz")
    private List<Question> question;

    @ManyToOne
    @JoinColumn(name ="utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

}
