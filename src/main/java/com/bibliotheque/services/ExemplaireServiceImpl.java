package com.bibliotheque.services;

import com.bibliotheque.beans.Bibliotheque;
import com.bibliotheque.beans.Edition;
import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.repositories.BibliothequeRepo;
import com.bibliotheque.repositories.EditionRepo;
import com.bibliotheque.repositories.ExemplaireRepo;
import com.bibliotheque.repositories.OeuvreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {

	@Autowired
	private ExemplaireRepo eR;

	@Autowired
	private BibliothequeRepo bR;


	public List<Edition> getAllEditionByBiblio(int idBibliotheque) {
		return eR.findEditionByBiblio(idBibliotheque);
	}

	public List<Integer> getCountsOfExemplaires(int idBibliotheque) {
		return eR.findCountOfExemplaires(idBibliotheque);
	}

	public int getCountOfExemplaireByEdition(int idBibliotheque, int idEdition) {
		int count = eR.findCountOfExemplaireByEdition(idBibliotheque, idEdition);
		return count;
	}

	public Optional<Exemplaire> getExemplaireById(int id) {
		Optional<Exemplaire> ex = eR.findById(id);
		return ex;
	}

	public Exemplaire saveExemplaire(Exemplaire exemplaire, int idBibliotheque){
		Bibliotheque b = bR.findById(idBibliotheque).get();
		exemplaire.setBibliotheque(b);
		return eR.save(exemplaire);
	}
}

