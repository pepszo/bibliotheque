package com.bibliotheque.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Amende {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idAmende", nullable=false)
    private int idAmende;

    @Column(name="motif")
    private String motif;

    @Column(name="montant")
    private Float montant;

}
