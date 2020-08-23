package com.bibliotheque.beans;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Etats")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idEtat",
        scope = Etat.class)
@JsonIgnoreProperties({"exempl"})
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idEtat", nullable=false)
    private int idEtat;

    @Column(name="label")
    private String label;

    @OneToMany(mappedBy = "etat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Exemplaire> exempl;

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

    @JsonProperty("exempl")
    public Set<Exemplaire> getExemplaires() {
        return exempl;
    }

    @JsonProperty("exempl")
    public void setExemplaires(Set<Exemplaire> exemplaires) {
        this.exempl = exemplaires;
    }
}
