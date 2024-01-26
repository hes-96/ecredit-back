package com.gti.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gti.ecredit.entities.PieceJointe;

@Repository
public interface PieceRepo extends JpaRepository<PieceJointe, Long>{

}
