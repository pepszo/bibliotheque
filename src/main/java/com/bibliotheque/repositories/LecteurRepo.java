package com.bibliotheque.repositories;

import com.bibliotheque.beans.Lecteur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LecteurRepo extends CrudRepository<Lecteur, Integer> {

    @Query(value = "select idLecteur from lecteurs where email = ?1", nativeQuery = true)
    int findiDByEmail(String emailLecteur);

    @Query(value = "select * from lecteurs where email = ?1", nativeQuery = true)
    Optional<Lecteur>findByEmail(String emailLecteur);

}
