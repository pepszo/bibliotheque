package com.bibliotheque.controllers;

import com.bibliotheque.beans.Lecteur;
import com.bibliotheque.services.LecteurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class LecteurController {

	@Autowired
	private LecteurServiceImpl lSI;
	
	@GetMapping("/lecteur")
	private Set<Lecteur> getAllLecteur(){
		return lSI.getAllLecteur();
	}
	
	@GetMapping("/lecteur/{id}")
	private Optional<Lecteur> getLecteurById(@PathVariable int id) {
		return lSI.getLecteurById(id);
	}
	
	@PostMapping("/lecteur")
	private Lecteur addLecteur(@RequestBody Lecteur lecteur) {
		return lSI.saveLecteur(lecteur);
	}
	
	@PutMapping("/lecteur/{id}")
    public Lecteur updateLecteur(@RequestBody Lecteur lecteur, @PathVariable int id) {
        return lSI.setLecteur(lecteur, id);
    }
	
	@DeleteMapping("/lecteur/{id}")
	public void deletLecteur(@PathVariable int id) {
		lSI.deleteLecteur(id);
	}
}
