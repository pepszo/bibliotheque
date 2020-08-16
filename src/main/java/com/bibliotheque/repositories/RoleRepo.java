package com.bibliotheque.repositories;

import com.bibliotheque.beans.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {

}
