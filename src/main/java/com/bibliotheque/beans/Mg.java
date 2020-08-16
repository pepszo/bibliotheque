package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name ="Mg")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idMg")
public class Mg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idMg", nullable=false)
    private int idMg;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="adresse")
    private String adresse;

    @Column(name="dateN")
    private Date dateN;

    @Column(name="email")
    private String email;

    @Column(name="mdp")
    private String mdp;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idRole")
    private Role role;

    public int getIdMg() {
        return idMg;
    }

    public void setIdMg(int idMg) {
        this.idMg = idMg;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateN() {
        return dateN;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
