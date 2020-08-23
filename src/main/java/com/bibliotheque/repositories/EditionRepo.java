package com.bibliotheque.repositories;

import com.bibliotheque.beans.Edition;
import com.bibliotheque.beans.Oeuvre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EditionRepo extends CrudRepository<Edition, Integer> {
     List<Edition> findByOeuvre(int id);
}
