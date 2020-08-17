package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Editions")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idEdition")
public class Edition {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idEdition", nullable=false)
    private int idEdition;

    @Column(name="nomEditeur")
    private String nomEditeur;

    @Column(name="dateEdition")
    private Date dateEdition;

	@OneToMany(mappedBy = "edition", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Exemplaire> exemplaire;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "idOeuvre")
	private Oeuvre oeuvre;

    
	public int getIdEdition() {
		return idEdition;
	}

	public void setIdEdition(int idEdition) {
		this.idEdition = idEdition;
	}

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}
	@JsonIgnore
	public Set<Exemplaire> getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Set<Exemplaire> exemplaire) {
		this.exemplaire = exemplaire;
	}

	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}


}
