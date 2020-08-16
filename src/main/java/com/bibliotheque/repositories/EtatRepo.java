package com.bibliotheque.repositories;

import com.bibliotheque.beans.Etat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatRepo extends CrudRepository<Etat, Integer> {
}
