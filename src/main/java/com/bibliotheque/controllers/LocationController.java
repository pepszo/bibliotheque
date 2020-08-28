package com.bibliotheque.controllers;

import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.beans.Location;
import com.bibliotheque.repositories.LocationRepo;
import com.bibliotheque.services.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/location")
public class LocationController {
	
	@Autowired
	private LocationServiceImpl lSI;
	
	@PostMapping("/new")
	public List<Location> addLocation(@RequestBody List<Integer> idExemplaires, @RequestParam String email) {
		return lSI.saveLocations(idExemplaires, email);
	}
	
	@GetMapping("/location")
	public Set<Location> getAllLocation(){
		return lSI.getAllLocation();
	}
	
	@GetMapping("/location/{id}")
	public Optional<Location> geLocationtById(@PathVariable int id) {
		Optional<Location> location = lSI.getLocationById(id);
		return location;
	}
}
