package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Locations")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idLocation", scope = com.bibliotheque.beans.Location.class)
public class Location {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idLocation", nullable=false)
    private int idLocation;

    @Column(name="dateDebut")
    private Date dateDebut;

    @Column(name="dateFin")
    private Date dateFin;
    
    @Column(name="dateRendu")
    private Date dateRendu;
    
    @Column(name="etatDebut")
    private int etatDebut;
    
    @Column(name="etatRendu")
    private int etatRendu;
    
    @Column(name="statut")
    private int statut;
    
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idLecteur")
    private Lecteur lecteur;
    
    @ManyToMany(mappedBy = "location",fetch = FetchType.LAZY)
    private Set<Exemplaire> exemplaire = new HashSet<>();

    @JsonIgnore
	public Lecteur getLecteur() {
		return lecteur;
	}
    
	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}

	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Date getDateRendu() {
		return dateRendu;
	}

	public void setDateRendu(Date dateRendu) {
		this.dateRendu = dateRendu;
	}

	public int getEtatDebut() {
		return etatDebut;
	}

	public void setEtatDebut(int etatDebut) {
		this.etatDebut = etatDebut;
	}

	public int getEtatRendu() {
		return etatRendu;
	}

	public void setEtatRendu(int etatRendu) {
		this.etatRendu = etatRendu;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}


	public Set<Exemplaire> getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Set<Exemplaire> exemplaire) {
		this.exemplaire = exemplaire;
	}
    
    

}

