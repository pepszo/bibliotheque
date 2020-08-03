package com.bibliotheque.repositories;

import com.bibliotheque.beans.Exemplaire;
import com.bibliotheque.beans.Oeuvre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ExemplaireRepo extends CrudRepository<Exemplaire, Integer> {
	
	List<Exemplaire> findByOeuvre(Optional<Oeuvre> oeuvre);
	
}
