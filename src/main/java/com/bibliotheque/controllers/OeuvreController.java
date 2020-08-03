package com.bibliotheque.controllers;

import com.bibliotheque.beans.Oeuvre;
import com.bibliotheque.services.OeuvreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class OeuvreController {

	@Autowired
	private OeuvreServiceImpl oSI;
	
	@GetMapping("/oeuvre")
	private Set<Oeuvre> getAllExemplaire(){
		return oSI.getAllOeuvre();
	}
	
	@GetMapping("/oeuvre/{id}")
	private Optional<Oeuvre> getOeuvreById(@PathVariable int id) {
		Optional<Oeuvre> oeuvre = oSI.getOeuvreById(id);
		return oeuvre;
	}
	
	@PostMapping("/oeuvre")
	private Oeuvre addOeuvre(@RequestBody Oeuvre oeuvre) {
		oeuvre = oSI.saveOeuvre(oeuvre);
		return oeuvre;
	}
	
	@PutMapping("/oeuvre/{id}")
    public Oeuvre updateOeuvre(@RequestBody Oeuvre oeuvre, @PathVariable int id) {
        return oSI.setOeuvre(oeuvre, id);
    }
	
	@DeleteMapping("/oeuvre/{id}")
	public void deletOeuvre(@PathVariable int id) {
		oSI.deleteOeuvre(id);
	}
}
