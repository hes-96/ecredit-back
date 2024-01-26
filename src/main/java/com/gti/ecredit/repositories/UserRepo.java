package com.gti.ecredit.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gti.ecredit.entities.AppUser;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Long>{
	Optional<AppUser> findByUsername( String username);
    
    Optional<AppUser> findByEmail( String email);

    Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
