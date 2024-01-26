package com.gti.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gti.ecredit.entities.EtatDemande;

@Repository
public interface EtatRepo extends JpaRepository<EtatDemande, Long>{

}
