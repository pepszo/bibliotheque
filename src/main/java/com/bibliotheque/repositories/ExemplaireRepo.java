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

    @Query("SELECT distinct e.edition FROM Exemplaire e WHERE e.bibliotheque.idBibliotheque = ?1 order by e.edition.idEdition")
    List<Edition> findEditionByBiblio(int idBibliotheque);

    @Query("SELECT count(e.idExemplaire)  FROM Exemplaire e WHERE e.bibliotheque.idBibliotheque = ?1 and e.edition.idEdition = ?2")
    int findCountOfExemplaireByEdition(int idBibliotheque, int idEdition);

    @Query(value = "SELECT idEdition,count(*)  FROM exemplaires e WHERE e.idBibliotheque = ?1 and e.idExemplaire not in (select idExemplaire from locations) group by e.idEdition order by e.idEdition", nativeQuery = true)
    List<Object> findCountOfExemplaires(int idBibliotheque);

    @Query("SELECT e FROM Exemplaire e WHERE e.bibliotheque.idBibliotheque = ?1 and e.edition.idEdition = ?2")
    int findExemplaireByEdition(int idBibliotheque, int idEdition);

    @Query(value = "SELECT e.* FROM exemplaires AS e, locations AS l where idBibliotheque = ?1 and e.idExemplaire not in (select idExemplaire from locations) and idEdition = ?2 limit 1", nativeQuery = true)
    Exemplaire findOneExemplaireByEdition(String idBibliotheque, String idEdition);
}
