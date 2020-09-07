package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "Cotisations")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idCotisation",
        scope = Cotisation.class)
public class Cotisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCotisation", nullable = false)
    private int idCotisation;

    @Column(name = "dateDebut")
    private Date dateDebut;

    @Column(name = "dateFin")
    private Date dateFin;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idLecteur")
    private com.bibliotheque.beans.Lecteur lecteur;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idBibliotheque")
    private com.bibliotheque.beans.Bibliotheque bibliotheque;

    public int getIdCotisation() {
        return idCotisation;
    }

    public void setIdCotisation(int idCotisation) {
        this.idCotisation = idCotisation;
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
        c.add(Calendar.YEAR, 1);
        this.dateFin = c.getTime();
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Optional<Lecteur> lecteur) {
        this.lecteur = lecteur.get();
    }

    public com.bibliotheque.beans.Bibliotheque getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(com.bibliotheque.beans.Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }


}
