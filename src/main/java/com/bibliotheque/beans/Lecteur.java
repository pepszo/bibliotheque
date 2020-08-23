package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.bibliotheque.services.Password;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="Lecteurs")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idLecteur", scope = Lecteur.class)
public class Lecteur {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idLecteur", nullable=false)
    private int idLecteur;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;
    
    @Column(name="adresse")
    private String adresse;
    
    @Column(name="tel")
    private String tel;
    
    @Column(name="email")
    private String email;
    
    @Column(name="mdp")
    private String mdp;
    

    @OneToMany(mappedBy = "lecteur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Cotisation> cotisation;
    
    @OneToMany(mappedBy = "lecteur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<com.bibliotheque.beans.Location> location;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "idRole")
	private Role role;

    
	public Set<com.bibliotheque.beans.Location> getLocation() {
		return location;
	}


	public void setLocation(Set<com.bibliotheque.beans.Location> location) {
		this.location = location;
	}


	public int getIdLecteur() {
		return idLecteur;
	}


	public void setIdLecteur(int idLecteur) {
		this.idLecteur = idLecteur;
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


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
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


	public Set<Cotisation> getCotisation() {
		return cotisation;
	}


	public void setCotisation(Set<Cotisation> cotisation) {
		this.cotisation = cotisation;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
