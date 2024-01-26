package com.gti.ecredit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.ecredit.entities.EtatDemande;
import com.gti.ecredit.repositories.EtatRepo;

@Service
@Transactional
public class EtatService {
	@Autowired
    private EtatRepo etatDemandeRepository;

    public List<EtatDemande> getAllEtatDemandes() {
        return etatDemandeRepository.findAll();
    }

    public EtatDemande getEtatDemandeById(Long id) {
        return etatDemandeRepository.findById(id).orElse(null);
    }

    public EtatDemande createEtatDemande(EtatDemande etatDemande) {
        return etatDemandeRepository.save(etatDemande);
    }

    public EtatDemande updateEtatDemande(Long id, EtatDemande updatedEtatDemande) {
        if (etatDemandeRepository.existsById(id)) {
            updatedEtatDemande.setId(id);
            return etatDemandeRepository.save(updatedEtatDemande);
        } else {
            return null; // EtatDemande not found
        }
    }

    public boolean deleteEtatDemande(Long id) {
        if (etatDemandeRepository.existsById(id)) {
            etatDemandeRepository.deleteById(id);
            return true;
        } else {
            return false; // EtatDemande not found
        }
    }
}
