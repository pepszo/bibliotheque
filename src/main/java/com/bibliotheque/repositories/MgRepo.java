package com.bibliotheque.repositories;

import com.bibliotheque.beans.Mg;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MgRepo extends CrudRepository<Mg, Integer> {
    Optional<Mg> findByEmail(String email);
}
