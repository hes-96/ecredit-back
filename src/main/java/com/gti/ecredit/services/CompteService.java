package com.gti.ecredit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.ecredit.entities.Compte;
import com.gti.ecredit.repositories.CompteRepo;
@Service
@Transactional
public class CompteService {
	@Autowired
    private CompteRepo compteRepository;

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public Compte getCompteById(Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    public Compte createCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public Compte updateCompte(Long id, Compte updatedCompte) {
        if (compteRepository.existsById(id)) {
            updatedCompte.setId(id);
            return compteRepository.save(updatedCompte);
        } else {
            return null; // Compte not found
        }
    }

    public boolean deleteCompte(Long id) {
        if (compteRepository.existsById(id)) {
            compteRepository.deleteById(id);
            return true;
        } else {
            return false; // Compte not found
        }
    }
}
