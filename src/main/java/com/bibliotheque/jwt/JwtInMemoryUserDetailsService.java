package com.bibliotheque.jwt;

import com.bibliotheque.beans.Bibliothecaire;
import com.bibliotheque.repositories.BibliothecaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  private BibliothecaireRepo bR ;
	
	
  //static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  //static {
  //  inMemoryUserList.add(new JwtUserDetails(1L, "toto",
  //      "$2a$10$Bi7DWJTLZp4fjT8oT96q0erNCzQD5QtR62uT1v7QFWddmp3c9.g.G", "ADMIN"));
  //}

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    
	  Optional<Bibliothecaire> bibliothecaire = bR.findByEmail(email);
	    
	  Optional<JwtUserDetails> user = Optional.empty();
	  
	  if(bibliothecaire.isPresent()) {
		  user = Optional.of(new JwtUserDetails(bibliothecaire.get().getIdBibliothecaire(),bibliothecaire.get().getEmail(),bibliothecaire.get().getMdp(),bibliothecaire.get().getRole()));
	  }
	  
	  //Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
      //  .filter(user -> user.getUsername().equals(username)).findFirst();

	  if (!user.isPresent()) {
		  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", email));
	  }

	  return user.get();
  }

}
