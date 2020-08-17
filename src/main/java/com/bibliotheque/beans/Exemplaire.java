package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Exemplaires")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idExemplaire")
public class Exemplaire {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idExemplaire", nullable=false)
    private int idExemplaire;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idBibliotheque")
    private com.bibliotheque.beans.Bibliotheque bibliotheque;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idEdition")
    private Edition edition;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "idEtat")
	private Etat etat;


	public int getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}
	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	@JsonIgnore
	public com.bibliotheque.beans.Bibliotheque getBibliotheque() {
		return bibliotheque;
	}

	public void setBibliotheque(com.bibliotheque.beans.Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

    
}
