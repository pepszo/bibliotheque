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

    @GetMapping("cotisation/{emailLecteur}")
    private List<String> getallCotisationByLecteur(@PathVariable String emailLecteur) {
        return cSI.getallCotisationByLecteur(emailLecteur);
    }

    @PostMapping("cotisation/new")
    private Cotisation newCotisation(@RequestParam String emailLecteur, int idBibliotheque) {
        return cSI.saveCotisation(emailLecteur, idBibliotheque);
    }


}
