package com.bibliotheque.services;

import com.bibliotheque.beans.Bibliotheque;
import com.bibliotheque.repositories.BibliothequeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BibliothequeServiceImpl implements BibliothequeService {

    @Autowired
    private BibliothequeRepo bR;

    public List<Bibliotheque> getAllBibliotheque() {
        List<Bibliotheque> biblio = new ArrayList<>((Collection<Bibliotheque>) bR.findAll());
        return biblio;
    }

    public Optional<Bibliotheque> getBibliothequeById(int id) {
        Optional<Bibliotheque> bibliotheque = bR.findById(id);
        return bibliotheque;
    }

    public Bibliotheque saveBibliotheque(Bibliotheque bibliotheque) {
        try {
            return bR.save(bibliotheque);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("La bibliotheque existe déjà");
        }
    }
}
