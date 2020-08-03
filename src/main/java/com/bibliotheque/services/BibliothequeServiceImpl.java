package com.bibliotheque.services;

import com.bibliotheque.beans.Bibliotheque;
import com.bibliotheque.repositories.BibliothequeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BibliothequeServiceImpl implements BibliothequeService{

	@Autowired
	private BibliothequeRepo bR;
	
	public Set<Bibliotheque> getAllBibliotheque() {
		Set<Bibliotheque> biblio = new HashSet<Bibliotheque>((Collection<Bibliotheque>) bR.findAll());
				return biblio;
	}
	
	public Optional<Bibliotheque> getBibliothequeById(int id) {
		Optional<Bibliotheque> bibliotheque = bR.findById(id);
		return bibliotheque;
	}
}
