package com.bibliotheque.controllers;

import com.bibliotheque.beans.Bibliotheque;
import com.bibliotheque.beans.Edition;
import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.services.ExemplaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "bibliotheque/{idBibliotheque}")
public class ExemplaireController {
	
	@Autowired
	private ExemplaireServiceImpl eSI;


	@GetMapping("/edition")
	public List<Edition> getAllEditionByBiblio(@PathVariable int idBibliotheque){
		return eSI.getAllEditionByBiblio(idBibliotheque);
	}

	@GetMapping("/edition/{idEdition}")
	public int getCountOfExemplaireByEdition(@PathVariable int idBibliotheque, @PathVariable int idEdition){
		return eSI.getCountOfExemplaireByEdition(idBibliotheque, idEdition);
	}

}
