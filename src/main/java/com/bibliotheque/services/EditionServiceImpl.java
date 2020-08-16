package com.bibliotheque.services;

import com.bibliotheque.beans.Edition;
import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.repositories.EditionRepo;
import com.bibliotheque.repositories.OeuvreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EditionServiceImpl {

    @Autowired
    private EditionRepo eR;

    @Autowired
    private OeuvreRepo oR;

    public List<Edition> getAllEditionByOeuvre(int id) {

        List<Edition> editions = new ArrayList<>(eR.findByOeuvre(id));
        return editions;
    }
    public Optional<Edition> getEditionById(int id) {
        Optional<Edition> ed = eR.findById(id);
        return ed;
    }
}
