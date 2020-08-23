package com.bibliotheque.controllers;

import com.bibliotheque.beans.Etat;
import com.bibliotheque.services.EtatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/etat")
public class EtatController {

    @Autowired
    private EtatServiceImpl eSI;

    @GetMapping("/all")
    public List<Etat> allEtats(){
        return eSI.getAllEtats();
    }
}
