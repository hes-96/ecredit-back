package com.gti.ecredit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gti.ecredit.entities.AppUser;

@Repository
public interface ClientRepo extends JpaRepository<AppUser, Long>{

	Optional<AppUser> findByCin(Long cin);

}
