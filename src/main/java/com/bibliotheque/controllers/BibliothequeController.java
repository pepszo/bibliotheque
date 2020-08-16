package com.bibliotheque.controllers;

import com.bibliotheque.beans.Bibliotheque;
import com.bibliotheque.services.BibliothequeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/bibliotheque")
public class BibliothequeController {

	@Autowired
	private BibliothequeServiceImpl bSI;
	
	@GetMapping("/all")
	public List<Bibliotheque> allBibliotheque(){
		return bSI.getAllBibliotheque();
	}

	@GetMapping("/{id}")
	public Optional<Bibliotheque> getBibliothequeByid(@PathVariable int id) {
		Optional<Bibliotheque> biblio = bSI.getBibliothequeById(id);
		return biblio;
	}

	@PostMapping("/new")
	private Bibliotheque newBiblio(@RequestBody Bibliotheque bibliotheque) { return bSI.saveBibliotheque(bibliotheque);}

}
