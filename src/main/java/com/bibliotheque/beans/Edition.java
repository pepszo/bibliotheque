package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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

    @Column(name="nomEdition")
    private String nomEdition;

    @Column(name="dateEdition")
    private Date dateEdition;
    
    @ManyToMany(cascade = { CascadeType.MERGE },fetch = FetchType.EAGER)
    @JoinTable(
            name = "EditionsOeuvres", 
            joinColumns = { @JoinColumn(name = "idEdition") }, 
            inverseJoinColumns = { @JoinColumn(name = "idOeuvre") }
        )
    private Set<Oeuvre> oeuvre = new HashSet<>();

    
	public int getIdEdition() {
		return idEdition;
	}

	public void setIdEdition(int idEdition) {
		this.idEdition = idEdition;
	}

	public String getNomEdition() {
		return nomEdition;
	}

	public void setNomEdition(String nomEdition) {
		this.nomEdition = nomEdition;
	}

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}

	public Set<Oeuvre> getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Set<Oeuvre> oeuvre) {
		this.oeuvre = oeuvre;
	}
    
    
    
}
