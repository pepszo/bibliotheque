package com.bibliotheque.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Oeuvres")
public class Oeuvre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOeuvre", nullable = false)
    private int idOeuvre;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "titre")
    private String titre;

    @Column(name = "descri")
    private String descri;

    @OneToMany(mappedBy = "oeuvre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Edition> edition;


    public int getIdOeuvre() {
        return idOeuvre;
    }

    public void setIdOeuvre(int idOeuvre) {
        this.idOeuvre = idOeuvre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    @JsonIgnore
    public Set<com.bibliotheque.beans.Edition> getEdition() {
        return edition;
    }

    public void setEdition(Set<com.bibliotheque.beans.Edition> edition) {
        this.edition = edition;
    }


}
