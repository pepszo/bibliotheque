package com.bibliotheque.repositories;

import com.bibliotheque.beans.Cotisation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CotisationRepo extends CrudRepository<Cotisation, Integer> {

    @Query(value = "select idBibliotheque from cotisations where idLecteur = ?1", nativeQuery = true)
    List<Integer> findPermissionsByLecteur(int idLecteur);

    @Query(value = "select idBibliotheque from cotisations where idLecteur = ?1", nativeQuery = true)
    List<String> findAllByLecteur(int idLecteur);

}
