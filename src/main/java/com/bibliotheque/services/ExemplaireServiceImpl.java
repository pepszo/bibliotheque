package com.bibliotheque.services;

import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.repositories.ExemplaireRepo;
import com.bibliotheque.repositories.OeuvreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {

	@Autowired
	private ExemplaireRepo eR;
	
	@Autowired
	private OeuvreRepo oR;

	public Set<Exemplaire> getAllExemplaireByOeuvre(int id) {
		
		Set<Exemplaire> exemp = new HashSet<Exemplaire>((Collection<Exemplaire>) eR.findByOeuvre(oR.findById(id)));
				return exemp;
	}
	public Optional<Exemplaire> getExemplaireById(int id) {
		Optional<Exemplaire> ex = eR.findById(id);
		return ex;
	}
}

