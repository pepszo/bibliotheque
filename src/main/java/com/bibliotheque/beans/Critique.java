package com.bibliotheque.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Critique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCritique", nullable = false)
    private int idCritique;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "note")
    private Float note;
}
