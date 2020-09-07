package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Roles")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idRole")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRole", nullable = false)
    private int idRole;

    @Column(name = "label")
    private String label;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Bibliothecaire> bibliothecaire;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Lecteur> lecteur;

    @OneToOne(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Mg mg;

    public Set<Bibliothecaire> getBibliothecaire() {
        return bibliothecaire;
    }

    public void setBibliothecaire(Set<Bibliothecaire> bibliothecaire) {
        this.bibliothecaire = bibliothecaire;
    }

    public Set<Lecteur> getLecteur() {
        return lecteur;
    }

    public void setLecteur(Set<Lecteur> lecteur) {
        this.lecteur = lecteur;
    }
}
