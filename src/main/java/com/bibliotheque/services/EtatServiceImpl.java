package com.bibliotheque.services;

import com.bibliotheque.beans.Etat;
import com.bibliotheque.repositories.EtatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EtatServiceImpl implements EtatService{

    @Autowired
    private EtatRepo eR;

    public List<Etat> getAllEtats() {
        List<Etat> etats = new ArrayList<>((Collection<Etat>) eR.findAll());
        return etats;
    }

}
