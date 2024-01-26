package com.gti.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gti.ecredit.entities.Garantie;

@Repository
public interface GarantieRepo extends JpaRepository<Garantie, Long>{

}
