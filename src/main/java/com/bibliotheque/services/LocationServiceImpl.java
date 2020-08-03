package com.bibliotheque.services;

import com.bibliotheque.beans.Location;
import com.bibliotheque.repositories.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class LocationServiceImpl implements com.bibliotheque.services.LocationService {
	
	@Autowired
	private LocationRepo lR;
	
	public Set<Location> getAllLocation(){
		Set<Location> location = new HashSet<Location>((Collection<Location>) lR.findAll());
		return location;
	}
	
	public Optional<Location> getLocationById(int id) {
		Optional<Location> location = lR.findById(id);
		return location;
	}
	
}
