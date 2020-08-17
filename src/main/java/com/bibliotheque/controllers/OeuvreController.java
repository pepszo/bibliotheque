package com.bibliotheque.controllers;

import com.bibliotheque.beans.Oeuvre;
import com.bibliotheque.services.OeuvreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/oeuvre")
public class OeuvreController {

	@Autowired
	private OeuvreServiceImpl oSI;
	
	@GetMapping("/all")
	private List<Oeuvre> getAllOeuvre(){
		return oSI.getAllOeuvre();
	}
	
	@GetMapping("/{id}")
	private Optional<Oeuvre> getOeuvreById(@PathVariable int id) {
		Optional<Oeuvre> oeuvre = oSI.getOeuvreById(id);
		return oeuvre;
	}
	
	@PostMapping("/new")
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
