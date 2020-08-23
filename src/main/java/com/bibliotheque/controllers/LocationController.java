package com.bibliotheque.controllers;

import com.bibliotheque.beans.Location;
import com.bibliotheque.repositories.LocationRepo;
import com.bibliotheque.services.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.Set;


@RestController
public class LocationController {
	
	@Autowired 
	private LocationRepo lR;
	
	@Autowired
	private LocationServiceImpl lSI;
	
	@PostMapping("/location")
	public Location addLocation(@RequestBody Location location) {
		
		/*LocalDateTime t = LocalDateTime.now();
		Date dateLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant());
		Date dateDebutLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(86400));
		Date dateFinLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(2592000));*/
		location.setDateDebut();
		location.setDateFin();
		
		return lR.save(location);
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
