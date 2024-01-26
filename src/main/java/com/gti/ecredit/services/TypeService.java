package com.gti.ecredit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.ecredit.entities.TypeCredit;
import com.gti.ecredit.repositories.TypeRepo;

@Service
@Transactional
public class TypeService {
	@Autowired
    private TypeRepo typeCreditRepository;

    public List<TypeCredit> getAllTypeCredits() {
        return typeCreditRepository.findAll();
    }

    public TypeCredit getTypeCreditById(Long id) {
        return typeCreditRepository.findById(id).orElse(null);
    }

    public TypeCredit createTypeCredit(TypeCredit typeCredit) {
        return typeCreditRepository.save(typeCredit);
    }

    public TypeCredit updateTypeCredit(Long id, TypeCredit updatedTypeCredit) {
        if (typeCreditRepository.existsById(id)) {
            updatedTypeCredit.setId(id);
            return typeCreditRepository.save(updatedTypeCredit);
        } else {
            return null; // TypeCredit not found
        }
    }

    public boolean deleteTypeCredit(Long id) {
        if (typeCreditRepository.existsById(id)) {
            typeCreditRepository.deleteById(id);
            return true;
        } else {
            return false; // TypeCredit not found
        }
    }
}
