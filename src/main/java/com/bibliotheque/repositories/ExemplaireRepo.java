package com.bibliotheque.repositories;

import com.bibliotheque.beans.Edition;
import com.bibliotheque.beans.Exemplaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ExemplaireRepo extends CrudRepository<Exemplaire, Integer> {

	@Query("SELECT distinct e.edition FROM Exemplaire e WHERE e.bibliotheque.idBibliotheque = ?1")
			List<Edition> findEditionByBiblio(int idBibliotheque);

	@Query("SELECT count(e.idExemplaire)  FROM Exemplaire e WHERE e.bibliotheque.idBibliotheque = ?1 and e.edition.idEdition = ?2")
	int findCountOfExemplaireByEdition(int idBibliotheque, int idEdition);

	@Query("SELECT e FROM Exemplaire e WHERE e.bibliotheque.idBibliotheque = ?1 and e.edition.idEdition = ?2")
	int findExemplaireByEdition(int idBibliotheque, int idEdition);
	
}
