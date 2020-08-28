package com.bibliotheque.services;

import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.beans.Lecteur;
import com.bibliotheque.beans.Location;
import com.bibliotheque.repositories.ExemplaireRepo;
import com.bibliotheque.repositories.LecteurRepo;
import com.bibliotheque.repositories.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocationServiceImpl implements com.bibliotheque.services.LocationService {
	
	@Autowired
	private LocationRepo lR;

	@Autowired
	private ExemplaireRepo exemplaireRepo;

	@Autowired
	private LecteurRepo lecteurRepo;
	
	public Set<Location> getAllLocation(){
		Set<Location> location = new HashSet<Location>((Collection<Location>) lR.findAll());
		return location;
	}
	
	public Optional<Location> getLocationById(int id) {
		Optional<Location> location = lR.findById(id);
		return location;
	}

	public List<Location> saveLocations(List<Integer> idExemplaires, String emailLecteur) {
		List<Location> locations = new ArrayList<>();
		Optional<Lecteur> lecteur = lecteurRepo.findByEmail(emailLecteur);
		for (int idExemplaire: idExemplaires) {
			Location l = new Location();
			Exemplaire e = new Exemplaire();
			l.setExemplaire(exemplaireRepo.findById(idExemplaire).get());
			System.out.println(l.getExemplaire().getIdExemplaire());
			l.setDateDebut();
			l.setDateFin();
			l.setLecteur(lecteur.get());
			lR.save(l);
			locations.add(l);
		}
		return locations;
	}
	
}
