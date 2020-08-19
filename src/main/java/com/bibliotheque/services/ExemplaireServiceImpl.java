package com.bibliotheque.services;

import com.bibliotheque.beans.Edition;
import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.repositories.EditionRepo;
import com.bibliotheque.repositories.ExemplaireRepo;
import com.bibliotheque.repositories.OeuvreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {

	@Autowired
	private ExemplaireRepo eR;


	public List<Edition> getAllEditionByBiblio(int idBibliotheque) {
		List<Edition> editions = new ArrayList<> (eR.findEditionByBiblio(idBibliotheque));
				return editions;
	}

	public int getCountOfExemplaireByEdition(int idBibliotheque, int idEdition) {
		int count = eR.findCountOfExemplaireByEdition(idBibliotheque, idEdition);
		return count;
	}

	public Optional<Exemplaire> getExemplaireById(int id) {
		Optional<Exemplaire> ex = eR.findById(id);
		return ex;
	}
}

