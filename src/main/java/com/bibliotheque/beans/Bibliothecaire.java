package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.bibliotheque.services.Password;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Bibliothecaires")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idBibliothecaire")
public class Bibliothecaire {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idBibliothecaire", nullable=false)
    private int idBibliothecaire;

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

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "idRole")
	private Role role;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "idBibliotheque")
	private com.bibliotheque.beans.Bibliotheque bibliotheque;
    

	public int getIdBibliothecaire() {
		return idBibliothecaire;
	}

	public void setIdBibliothecaire(int idBibliothecaire) {
		this.idBibliothecaire = idBibliothecaire;
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
        Password p = new Password(mdp);
        p.firstHash();
        this.mdp = p.getHash();
    }

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}

	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}
}

