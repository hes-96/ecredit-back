package com.gti.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gti.ecredit.entities.TypeCredit;

@Repository
public interface TypeRepo extends JpaRepository<TypeCredit, Long>{

}
