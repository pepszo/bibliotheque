package com.bibliotheque.repositories;

import com.bibliotheque.beans.Bibliothecaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface BibliothecaireRepo extends CrudRepository<Bibliothecaire, Integer> {
	
	@Query(value = "SELECT * FROM Bibliothecaires WHERE role = 3",nativeQuery=true)
    Set<Bibliothecaire> getAllBibliothecaire();
	
	@Query(value = "SELECT * FROM Bibliothecaires WHERE role = 2",nativeQuery=true)
    Set<Bibliothecaire> getAllManager();
	
	@Query(value = "SELECT * FROM Bibliothecaires WHERE role = 1",nativeQuery=true)
    Set<Bibliothecaire> getManagerGeneral();
	
	Optional<Bibliothecaire> findByEmail(String email);
	
}
