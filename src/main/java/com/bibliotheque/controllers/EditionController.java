package com.bibliotheque.controllers;

import com.bibliotheque.beans.Edition;
import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.services.EditionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/editions")
public class EditionController {

    @Autowired
    private EditionServiceImpl eSI;

    @GetMapping("/{id}")
    public List<Edition> getAllEditionsByOeuvre(@PathVariable int id){

        return eSI.getAllEditionByOeuvre(id);
    }
}
