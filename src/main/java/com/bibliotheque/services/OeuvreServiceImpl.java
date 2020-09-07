package com.bibliotheque.services;

import com.bibliotheque.beans.Oeuvre;
import com.bibliotheque.repositories.OeuvreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OeuvreServiceImpl {

    @Autowired
    private OeuvreRepo oR;

    public List<Oeuvre> getAllOeuvre() {
        List<Oeuvre> oeuvre = new ArrayList<>((Collection<Oeuvre>) oR.findAll());
        return oeuvre;
    }

    public Optional<Oeuvre> getOeuvreById(int id) {
        Optional<Oeuvre> oeuvre = oR.findById(id);
        return oeuvre;
    }

    public Oeuvre setOeuvre(Oeuvre oeuvre, int id) {
        Optional<Oeuvre> optionalOeuvreById = oR.findById(id);
        Oeuvre oeuvreById = optionalOeuvreById.get();
        oeuvreById.setDescri(oeuvre.getDescri());
        oeuvreById.setIsbn(oeuvre.getIsbn());
        oeuvreById.setTitre(oeuvre.getTitre());
        oR.save(oeuvreById);
        return oeuvreById;

    }

    public void deleteOeuvre(int id) {
        oR.deleteById(id);
    }

    public Oeuvre saveOeuvre(Oeuvre oeuvre) {
        oR.save(oeuvre);
        return oeuvre;
    }

}
