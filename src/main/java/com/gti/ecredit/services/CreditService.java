package com.gti.ecredit.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.ecredit.dto.CreditDto;
import com.gti.ecredit.entities.Compte;
import com.gti.ecredit.entities.Credit;
import com.gti.ecredit.entities.EtatDemande;
import com.gti.ecredit.entities.TypeCredit;
import com.gti.ecredit.entities.Unite;
import com.gti.ecredit.repositories.CompteRepo;
import com.gti.ecredit.repositories.CreditRepo;
import com.gti.ecredit.repositories.EtatRepo;
import com.gti.ecredit.repositories.TypeRepo;
import com.gti.ecredit.repositories.UniteRepo;

@Service
@Transactional
public class CreditService {
	@Autowired
    private CreditRepo creditRepository;
	@Autowired
    private CompteRepo compteRepository;
	@Autowired
    private TypeRepo typeRepository;
	@Autowired
    private EtatRepo etatRepository;
	@Autowired
    private UniteRepo uniteRepository;

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Credit getCreditById(Long id) {
        return creditRepository.findById(id).orElse(null);
    }

    public Credit createCredit(CreditDto creditDto) {
    	Credit credit = convertToEntity(creditDto);
    	System.out.println("1");
    	// Fetch related entities from the database
    	creditDto.setEtatId((long) 1);
    	System.out.println("2");
    	Compte compte = compteRepository.findById(creditDto.getCompteId()).orElse(null);
    	System.out.println("3");
        TypeCredit typeCredit = typeRepository.findById(creditDto.getTypeId()).orElse(null);
    	System.out.println("4");
        EtatDemande etatDemande = etatRepository.findById(creditDto.getEtatId()).orElse(null);
    	System.out.println("5");
        Unite unite = uniteRepository.findById(creditDto.getUniteId()).orElse(null);
    	System.out.println("6");
     // Check if related entities exist
        if (compte != null && typeCredit != null && etatDemande != null && unite != null) {
            // Set related entities on the credit
        	System.out.println("mehomch null");
            credit.setCompte(compte);
            credit.setType(typeCredit);
            credit.setEtat(etatDemande);
            credit.setUnite(unite);

            credit.calculMontantRembourse();
            // Save the Credit entity
            return creditRepository.save(credit);
        } else {
            // Handle the case where related entities do not exist
            throw new EntityNotFoundException("One or more related entities not found");
        }    
     }
    
    private Credit convertToEntity(CreditDto creditDto) {
        // Convert CreditDTO to Credit entity
        Credit credit = new Credit();
        credit.setMontant(creditDto.getMontant());
        credit.setNbEcheances(creditDto.getNbEcheances());
        credit.setEntreEnRelationLe(creditDto.getEntreEnRelationLe());
        credit.setPar(creditDto.getPar());
        credit.setDateDemande(creditDto.getDateDemande());
        credit.setNumDemande(creditDto.getNumDemande());
//      credit.setDecision(creditDto.getDecision());
        credit.setObservation(creditDto.getObservation());

        return credit;
    }

    public Credit updateCredit(Long id, CreditDto updatedCreditDTO) {
        // Check if the credit with the given id exists
        if (creditRepository.existsById(id)) {

            // Convert CreditDTO to Credit entity
            Credit updatedCredit = convertToEntity(updatedCreditDTO);

            // Set the id for the existing credit
            updatedCredit.setId(id);

            // Fetch related entities from the database
            Compte compte = compteRepository.findById(updatedCreditDTO.getCompteId()).orElse(null);
            TypeCredit typeCredit = typeRepository.findById(updatedCreditDTO.getTypeId()).orElse(null);
            EtatDemande etatDemande = etatRepository.findById(updatedCreditDTO.getEtatId()).orElse(null);
            Unite unite = uniteRepository.findById(updatedCreditDTO.getUniteId()).orElse(null);

            // Check if related entities exist
            if (compte != null && typeCredit != null && etatDemande != null && unite != null) {
                // Set related entities on the updated credit
                updatedCredit.setCompte(compte);
                updatedCredit.setType(typeCredit);
                updatedCredit.setEtat(etatDemande);
                updatedCredit.setUnite(unite);

                // Save the updated Credit entity
                return creditRepository.save(updatedCredit);
            } else {
                // Handle the case where related entities do not exist
                throw new EntityNotFoundException("One or more related entities not found");
            }
        } else {
            // Credit not found, return null or throw an exception based on your preference
            throw new EntityNotFoundException("Credit not found with id: " + id);
        }
    }


    public boolean deleteCredit(Long id) {
        if (creditRepository.existsById(id)) {
        	System.out.println('1');
            creditRepository.deleteById(id);
            return true;
        } else {
            return false; // Credit not found
        }
    }
    
    
    public Credit updateStatusToValide(Long id) {
    	System.out.println("1");
    	creditRepository.updateStatusToValide(id);
    	System.out.println("2");
    	return this.getCreditById(id);
    }
    
    public Credit updateStatusToRejete(Long id) {
    	creditRepository.updateStatusToRejete(id);
    	return this.getCreditById(id);
    }
}
