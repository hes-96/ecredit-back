package com.gti.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gti.ecredit.entities.Compte;

@Repository
public interface CompteRepo extends JpaRepository<Compte, Long>{

}
