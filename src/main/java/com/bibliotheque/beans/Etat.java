package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Etats")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idEtat")
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idEtat", nullable=false)
    private int idEtat;

    @Column(name="label")
    private String label;

    @OneToMany(mappedBy = "etat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Exemplaire> exemplaires;

    public int getIdEtat() {
        return idEtat;
    }

    public void setIdEtat(int idEtat) {
        this.idEtat = idEtat;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    @JsonIgnore
    public Set<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(Set<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
}
