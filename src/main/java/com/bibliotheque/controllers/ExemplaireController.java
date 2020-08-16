package com.bibliotheque.controllers;

import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.services.ExemplaireServiceImpl;
import com.bibliotheque.services.OeuvreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ExemplaireController {
	
	@Autowired
	private ExemplaireServiceImpl eSI;

	@Autowired
	private OeuvreServiceImpl oSI;
	
	@GetMapping("/exemplaires/{id}")
	public Set<Exemplaire> getAllExemplaireByOeuvre(@PathVariable int id){
		
		return eSI.getAllExemplaireByEdition(id);
	}

}
