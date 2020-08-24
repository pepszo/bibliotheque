package com.bibliotheque.services;

import com.bibliotheque.beans.Bibliotheque;
import com.bibliotheque.beans.Cotisation;
import com.bibliotheque.beans.Lecteur;
import com.bibliotheque.repositories.BibliothequeRepo;
import com.bibliotheque.repositories.CotisationRepo;
import com.bibliotheque.repositories.LecteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotisationServiceImpl implements CotisationService{

    @Autowired
    private CotisationRepo cR;

    @Autowired
    private BibliothequeRepo bR;

    @Autowired
    private LecteurRepo lR;

    public List<Integer> getPermissionsByLecteur(int idLecteur){
        if(cR.findPermissionsByLecteur(idLecteur) != null)
        {
            return cR.findPermissionsByLecteur(idLecteur);
        }
        return null;
    }

    public Cotisation saveCotisation(String emailLecteur, int idBibliotheque){
        Bibliotheque b = bR.findById(idBibliotheque).get();

        Optional<Lecteur> l;
        l = lR.findByEmail(emailLecteur);

        Cotisation cotisation = new Cotisation();
        cotisation.setBibliotheque(b);
        cotisation.setLecteur(l);
        cotisation.setDateDebut();
        cotisation.setDateFin();
        try{
            return cR.save(cotisation);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("La cotisation est déjà payé!");
        }
    }

    public List<String> getallCotisationByLecteur(String emailLecteur){
        int idLecteur = lR.findiDByEmail(emailLecteur);
        if (!cR.findAllByLecteur(idLecteur).isEmpty()) {
            return cR.findAllByLecteur(idLecteur);
        }
        return null;
    }
}

