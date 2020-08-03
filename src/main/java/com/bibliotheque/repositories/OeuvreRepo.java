package com.bibliotheque.repositories;

import com.bibliotheque.beans.Oeuvre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OeuvreRepo extends CrudRepository<Oeuvre, Integer> {

}
