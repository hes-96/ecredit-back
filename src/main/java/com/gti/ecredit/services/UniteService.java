package com.gti.ecredit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.ecredit.entities.Unite;
import com.gti.ecredit.repositories.UniteRepo;

@Service
@Transactional
public class UniteService {
	@Autowired
    private UniteRepo uniteRepository;

    public List<Unite> getAllUnites() {
        return uniteRepository.findAll();
    }

    public Unite getUniteById(Long id) {
        return uniteRepository.findById(id).orElse(null);
    }

    public Unite createUnite(Unite unite) {
        return uniteRepository.save(unite);
    }

    public Unite updateUnite(Long id, Unite updatedUnite) {
        if (uniteRepository.existsById(id)) {
            updatedUnite.setId(id);
            return uniteRepository.save(updatedUnite);
        } else {
            return null; // Unite not found
        }
    }

    public boolean deleteUnite(Long id) {
        if (uniteRepository.existsById(id)) {
            uniteRepository.deleteById(id);
            return true;
        } else {
            return false; // Unite not found
        }
    }
}
