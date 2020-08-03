package com.bibliotheque.controllers;

import com.bibliotheque.beans.Bibliothecaire;
import com.bibliotheque.services.BibliothecaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
public class BibliothecaireController {
	
	@Autowired
	private BibliothecaireServiceImpl bSI;
	
	@GetMapping("/bibliothecaire")
	private Set<Bibliothecaire> getAllBibliothecaire(){
		return bSI.getAllBibliothecaire();
	}
	
	@GetMapping("/bibliothecaire/byId/{id}")
	private Optional<Bibliothecaire> getBibliothecaireById(@PathVariable int id) {
		return bSI.getBibliothecaireById(id);
	}
	
	@GetMapping("/bibliothecaire/byRole/{role}")
	private Set<Bibliothecaire> getAllBibliothecaireByRole(@PathVariable int role) {
		return bSI.getAllBibliothecaireByRole(role);
	}
	
	@PostMapping("/bibliothecaire")
	private Bibliothecaire addBibliothecaire(@RequestBody Bibliothecaire bibliothecaire) {
		return bSI.saveBibliothecaire(bibliothecaire);
	}
	
	@PutMapping("/bibliothecaire/{id}")
    public Bibliothecaire updateBibliothecaire(@RequestBody Bibliothecaire bibliothecaire, @PathVariable int id) {
        return bSI.setBibliothecaire(bibliothecaire, id);
    }
	
	@DeleteMapping("/bibliothecaire/{id}")
	public void deletBibliothecaire(@PathVariable int id) {
		bSI.deleteBibliothecaire(id);
	}
}
