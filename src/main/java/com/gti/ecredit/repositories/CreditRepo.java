package com.gti.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gti.ecredit.entities.Credit;

@Repository
public interface CreditRepo extends JpaRepository<Credit, Long>{
	@Modifying
    @Query(value = " UPDATE CREDIT SET ETAT_ID = '2' WHERE id =:id", nativeQuery = true)
    void updateStatusToValide(@Param("id") Long id);
	
	@Modifying
    @Query(value = " UPDATE CREDIT SET ETAT_ID = '3' WHERE id =:id", nativeQuery = true)
    void updateStatusToRejete(@Param("id") Long id);
}
