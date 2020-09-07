package com.bibliotheque.services;

import com.bibliotheque.beans.Edition;
import com.bibliotheque.repositories.EditionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EditionServiceImpl {

    @Autowired
    private EditionRepo eR;


    public List<Edition> getAllEditionByOeuvre(int id) {

        List<Edition> editions = new ArrayList<>(eR.findByOeuvre(id));
        return editions;
    }

    public Optional<Edition> getEditionById(int id) {
        Optional<Edition> ed = eR.findById(id);
        return ed;
    }

    public List<Edition> getAllEditions() {
        List<Edition> biblio = new ArrayList<>((Collection<Edition>) eR.findAll());
        return biblio;
    }
}
