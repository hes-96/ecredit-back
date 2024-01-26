package com.gti.ecredit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gti.ecredit.entities.ERole;
import com.gti.ecredit.entities.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{
	Optional<Role> findByName(String name);
}
