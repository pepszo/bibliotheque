package com.bibliotheque.controllers;

import com.bibliotheque.beans.Bibliotheque;
import com.bibliotheque.beans.Cotisation;
import com.bibliotheque.services.CotisationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/bibliotheque/")
public class CotisationController {

    @Autowired
    private CotisationServiceImpl cSI;

    @GetMapping("cotisation/permissions/{idLecteur}")
    private List<Integer> getPermissionsByLecteur(@PathVariable int idLecteur) {
        return cSI.getPermissionsByLecteur(idLecteur);
    }

    @GetMapping("cotisation/{idLecteur}")
    private List<Cotisation> getallCotisationByLecteur(@PathVariable int idLecteur) {
        return cSI.getallCotisationByLecteur(idLecteur);
    }

    @PostMapping("{idBibliotheque}/cotisation/new")
    private Cotisation newCotisation(@RequestBody Cotisation cotisation, @PathVariable int idBibliotheque) { return cSI.saveCotisation(cotisation, idBibliotheque);}


}
