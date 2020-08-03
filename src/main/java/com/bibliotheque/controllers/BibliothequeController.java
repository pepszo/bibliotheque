package com.bibliotheque.controllers;

import com.bibliotheque.beans.Bibliotheque;
import com.bibliotheque.services.BibliothequeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class BibliothequeController {

	@Autowired
	private BibliothequeServiceImpl bSI;
	
	@GetMapping("/bibliotheques")
	public Set<Bibliotheque> allBibliotheque(){
		return bSI.getAllBibliotheque();
	}
	@GetMapping("/bibliotheques/{id}")
	public Optional<Bibliotheque> getid(@PathVariable int id) {
		Optional<Bibliotheque> biblio = bSI.getBibliothequeById(id);
		return biblio;
	}
}
