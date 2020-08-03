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

	@Column(name="titre")
    private String titre;

    @Column(name="prix")
    private Float prix;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idBibliotheque")
    private com.bibliotheque.beans.Bibliotheque bibliotheque;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idOeuvre")
    private com.bibliotheque.beans.Oeuvre oeuvre;

    @ManyToMany(cascade = { CascadeType.MERGE },fetch = FetchType.EAGER)
    @JoinTable(
            name = "ExemplairesReserve", 
            joinColumns = { @JoinColumn(name = "idExemplaire") }, 
            inverseJoinColumns = { @JoinColumn(name = "idLocation") }
        )
    private Set<com.bibliotheque.beans.Location> location = new HashSet<>();
    

	public com.bibliotheque.beans.Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(com.bibliotheque.beans.Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

	public int getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}
	@JsonIgnore
	public com.bibliotheque.beans.Bibliotheque getBibliotheque() {
		return bibliotheque;
	}

	public void setBibliotheque(com.bibliotheque.beans.Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}
    
    
}
