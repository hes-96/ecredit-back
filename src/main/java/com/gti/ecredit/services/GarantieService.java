package com.gti.ecredit.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.ecredit.dto.GarantieDto;
import com.gti.ecredit.entities.Credit;
import com.gti.ecredit.entities.Garantie;
import com.gti.ecredit.repositories.CreditRepo;
import com.gti.ecredit.repositories.GarantieRepo;

@Service
@Transactional
public class GarantieService {
	@Autowired
    private GarantieRepo garantieRepository;
	
	@Autowired
    private CreditRepo creditRepository;

    public List<Garantie> getAllGaranties() {
        return garantieRepository.findAll();
    }

    public Garantie getGarantieById(Long id) {
        return garantieRepository.findById(id).orElse(null);
    }

    public Garantie addGarantie(GarantieDto garantieDto) {
        Garantie garantie = convertToEntity(garantieDto);
        Credit credit = creditRepository.findById(garantieDto.getCreditId())
                .orElseThrow(() -> new EntityNotFoundException("Credit not found with id: " + garantieDto.getCreditId()));

        garantie.setCredit(credit);

        return garantieRepository.save(garantie);
    }

    public Garantie updateGarantie(Long id, GarantieDto updatedGarantieDto) {
        if (garantieRepository.existsById(id)) {
            Garantie updatedGarantie = convertToEntity(updatedGarantieDto);
            updatedGarantie.setId(id);

            Credit credit = creditRepository.findById(updatedGarantieDto.getCreditId())
                    .orElseThrow(() -> new EntityNotFoundException("Credit not found with id: " + updatedGarantieDto.getCreditId()));

            updatedGarantie.setCredit(credit);

            return garantieRepository.save(updatedGarantie);
        } else {
            return null; // Garantie not found
        }
    }
    
    private Garantie convertToEntity(GarantieDto garantieDto) {
        Garantie garantie = new Garantie();
        garantie.setNature(garantieDto.getNature());
        garantie.setType(garantieDto.getType());
        garantie.setValeur(garantieDto.getValeur());
        garantie.setDevise(garantieDto.getDevise());
        return garantie;
    }

    public boolean deleteGarantie(Long id) {
        if (garantieRepository.existsById(id)) {
            garantieRepository.deleteById(id);
            return true;
        } else {
            return false; // Garantie not found
        }
    }
}
