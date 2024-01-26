package com.gti.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gti.ecredit.entities.Unite;

@Repository
public interface UniteRepo extends JpaRepository<Unite, Long>{

}
