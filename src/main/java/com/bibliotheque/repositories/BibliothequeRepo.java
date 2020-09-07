package com.bibliotheque.repositories;

import com.bibliotheque.beans.Bibliotheque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliothequeRepo extends CrudRepository<Bibliotheque, Integer> {

}
