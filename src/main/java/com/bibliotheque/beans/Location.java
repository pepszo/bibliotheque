package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Locations")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idLocation", scope = Location.class)
public class Location {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idLocation", nullable=false)
    private int idLocation;

    @Column(name="dateDebut")
    private Date dateDebut;

    @Column(name="dateFin")
    private Date dateFin;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idLecteur")
    private Lecteur lecteur;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "idExemplaire")
	private Exemplaire exemplaire;

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

	public void setDateDebut() {
    	this.dateDebut = new Date();
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin() {
    	Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.MONTH, 1);
    	this.dateFin = c.getTime();
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

}

