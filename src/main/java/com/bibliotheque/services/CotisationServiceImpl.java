package com.bibliotheque.services;

import com.bibliotheque.beans.Bibliotheque;
import com.bibliotheque.beans.Cotisation;
import com.bibliotheque.repositories.BibliothequeRepo;
import com.bibliotheque.repositories.CotisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotisationServiceImpl implements CotisationService{

    @Autowired
    private CotisationRepo cR;

    @Autowired
    private BibliothequeRepo bR;

    public List<Integer> getPermissionsByLecteur(int idLecteur){
        if(cR.findPermissionsByLecteur(idLecteur) != null)
        {
            return cR.findPermissionsByLecteur(idLecteur);
        }
        return null;
    }

    public Cotisation saveCotisation(Cotisation cotisation, int idBibliotheque){
        Bibliotheque b = bR.findById(idBibliotheque).get();
        cotisation.setBibliotheque(b);
        cotisation.setDateDebut();
        cotisation.setDateFin();
        try{
            return cR.save(cotisation);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("La cotisation est déjà payé!");
        }
    }

    public List<Cotisation> getallCotisationByLecteur(int idLecteur){
        if(!cR.findAllByLecteur(idLecteur).isEmpty())
        {
            return cR.findAllByLecteur(idLecteur);
        }
        return null;
    }
}

