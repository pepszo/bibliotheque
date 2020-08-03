package com.bibliotheque.repositories;

import com.bibliotheque.beans.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends CrudRepository<Location, Integer> {

}
