package com.bibliotheque.repositories;

import com.bibliotheque.beans.Lecteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecteurRepo extends CrudRepository<Lecteur, Integer> {

}
