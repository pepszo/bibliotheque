package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Bibliotheques")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idBibliotheque")
public class Bibliotheque {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idBibliotheque", nullable=false)
    private int idBibliotheque;

    @Column(name="adresse")
    private String adresse;

    @Column(name="tel")
    private String tel;
    
    @OneToMany(mappedBy = "bibliotheque", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Exemplaire> exemp;
    
    @ManyToMany(cascade = { CascadeType.MERGE },fetch = FetchType.EAGER)
    @JoinTable(
            name = "BibliothequesBibliothecaires", 
            joinColumns = { @JoinColumn(name = "idBibliotheque") }, 
            inverseJoinColumns = { @JoinColumn(name = "idBibliothecaire") }
        )
    private Set<Bibliothecaire> bibliothecaire = new HashSet<>();

    @OneToMany(mappedBy = "bibliotheque", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Cotisation> cotisation;
    
    
	public int getIdBibliotheque() {
		return idBibliotheque;
	}

	public void setIdBibliotheque(int idBibliotheque) {
		this.idBibliotheque = idBibliotheque;
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
	
	public Set<Exemplaire> getExemp() {
		return exemp;
	}

	public void setExemp(Set<Exemplaire> exemp) {
		this.exemp = exemp;
	}

	@JsonIgnore
	public Set<Bibliothecaire> getBibliothecaire() {
		return bibliothecaire;
	}

	public void setBibliothecaire(Set<Bibliothecaire> bibliothecaire) {
		this.bibliothecaire = bibliothecaire;
	}
	@JsonIgnore
	public Set<Cotisation> getCotisation() {
		return cotisation;
	}

	public void setCotisation(Set<Cotisation> cotisation) {
		this.cotisation = cotisation;
	}    
    
    

}
