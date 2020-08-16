package com.bibliotheque.services;

import com.bibliotheque.beans.Bibliothecaire;
import com.bibliotheque.repositories.BibliothecaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BibliothecaireServiceImpl implements BibliothecaireService{

	@Autowired
	private BibliothecaireRepo bR;
	
	public Set<Bibliothecaire> getAllBibliothecaire(){
		Set<Bibliothecaire> bibliothecaire = new HashSet<>((Collection<Bibliothecaire>) bR.findAll());
		return bibliothecaire;
	}
	
	public Optional<Bibliothecaire> getBibliothecaireById(int id) {
		Optional<Bibliothecaire> bibliothecaire = bR.findById(id);
		return bibliothecaire;
	}
	
	public Set<Bibliothecaire> getAllBibliothecaireByRole(int role){
		Set<Bibliothecaire> bibliothecaire = new HashSet<>();
		if (role == 3) {
			bibliothecaire = bR.getAllBibliothecaire();
		}
		if (role == 2) {
			bibliothecaire = bR.getAllManager();
		}
		if (role == 1) {
			bibliothecaire = bR.getManagerGeneral();
		}
		return bibliothecaire;
	}
	
	public Bibliothecaire saveBibliothecaire(Bibliothecaire bibliothecaire) {
		return bR.save(bibliothecaire);
	}
	
	public Bibliothecaire setBibliothecaire(Bibliothecaire bibliothecaire, int id) {
		Optional<Bibliothecaire> optionalBibliothecaireById = bR.findById(id);
		Bibliothecaire bibliothecaireById = optionalBibliothecaireById.get();
		bibliothecaireById.setNom(bibliothecaire.getNom());
		bibliothecaireById.setPrenom(bibliothecaire.getPrenom());
		bibliothecaireById.setAdresse(bibliothecaire.getAdresse());
		bibliothecaireById.setDateN(bibliothecaire.getDateN());
		bibliothecaireById.setEmail(bibliothecaire.getEmail());
		bibliothecaireById.setMdp(bibliothecaire.getMdp());
		bibliothecaireById.setRole(bibliothecaire.getRole());
        bR.save(bibliothecaireById);
        return bibliothecaireById;
        
    }
	
	public void deleteBibliothecaire(int id) {
		bR.deleteById(id);
    }
}
