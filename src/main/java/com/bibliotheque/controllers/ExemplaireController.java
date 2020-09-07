package com.bibliotheque.controllers;

import com.bibliotheque.beans.Bibliotheque;
import com.bibliotheque.beans.Edition;
import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.services.ExemplaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TreeMap;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/bibliotheque/")
public class ExemplaireController {

    @Autowired
    private ExemplaireServiceImpl eSI;


    @GetMapping("{idBibliotheque}/edition")
    public List<Edition> getAllEditionByBiblio(@PathVariable int idBibliotheque) {
        return eSI.getAllEditionByBiblio(idBibliotheque);
    }

    @GetMapping("{idBibliotheque}/edition-counts")
    public List<Object> getCountsOfExemplaires(@PathVariable int idBibliotheque) {
        return eSI.getCountsOfExemplaires(idBibliotheque);
    }

    @GetMapping("{idBibliotheque}/edition/{idEdition}")
    public int getCountOfExemplaireByEdition(@PathVariable int idBibliotheque, @PathVariable int idEdition) {
        return eSI.getCountOfExemplaireByEdition(idBibliotheque, idEdition);
    }

    @GetMapping("/exemplaire")
    public Exemplaire getOneExemplaireByEdition(@RequestParam String idBibliotheque, String idEdition) {
        return eSI.getOneExemplaireByEdition(idBibliotheque, idEdition);
    }

    @PostMapping("{idBibliotheque}/add-book")
    private Exemplaire newExemplaire(@RequestBody Exemplaire exemplaire, @PathVariable int idBibliotheque) {
        return eSI.saveExemplaire(exemplaire, idBibliotheque);
    }


}
