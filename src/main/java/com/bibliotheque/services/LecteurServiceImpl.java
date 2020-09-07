package com.bibliotheque.services;

import com.bibliotheque.beans.Lecteur;
import com.bibliotheque.repositories.LecteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class LecteurServiceImpl implements com.bibliotheque.services.LecteurService {

    @Autowired
    private LecteurRepo lR;

    public Set<Lecteur> getAllLecteur() {
        Set<Lecteur> lecteur = new HashSet<Lecteur>((Collection<Lecteur>) lR.findAll());
        return lecteur;
    }

    public Optional<Lecteur> getLecteurById(int id) {
        Optional<Lecteur> lecteur = lR.findById(id);
        return lecteur;
    }

    public Lecteur saveLecteur(Lecteur lecteur) {
        return lR.save(lecteur);
    }

    public Lecteur setLecteur(Lecteur lecteur, int id) {
        Optional<Lecteur> optionalLecteurById = lR.findById(id);
        Lecteur lecteurById = optionalLecteurById.get();
        lecteurById.setNom(lecteur.getNom());
        lecteurById.setPrenom(lecteur.getPrenom());
        lecteurById.setAdresse(lecteur.getAdresse());
        lecteurById.setTel(lecteur.getTel());
        lecteurById.setEmail(lecteur.getEmail());
        lecteurById.setMdp(lecteur.getMdp());
        lR.save(lecteurById);
        return lecteurById;

    }

    public void deleteLecteur(int id) {
        lR.deleteById(id);
    }
}
