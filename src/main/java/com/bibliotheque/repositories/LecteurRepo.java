package com.bibliotheque.repositories;

import com.bibliotheque.beans.Lecteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LecteurRepo extends CrudRepository<Lecteur, Integer> {

    Optional<Lecteur> findByEmail(String email);

}
