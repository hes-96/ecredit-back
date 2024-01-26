package com.gti.ecredit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gti.ecredit.entities.EtatDemande;
import com.gti.ecredit.services.EtatService;

@RestController
@RequestMapping("/etats")
@CrossOrigin("${cross.origin.url}")
public class EtatController {
	@Autowired
    private EtatService etatDemandeService;

    @GetMapping
    public List<EtatDemande> getAllEtatDemandes() {
        return etatDemandeService.getAllEtatDemandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatDemande> getEtatDemandeById(@PathVariable Long id) {
        EtatDemande etatDemande = etatDemandeService.getEtatDemandeById(id);

        if (etatDemande != null) {
            return new ResponseEntity<>(etatDemande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EtatDemande> createEtatDemande(@RequestBody EtatDemande etatDemande) {
        EtatDemande createdEtatDemande = etatDemandeService.createEtatDemande(etatDemande);
        return new ResponseEntity<>(createdEtatDemande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtatDemande> updateEtatDemande(@PathVariable Long id, @RequestBody EtatDemande updatedEtatDemande) {
        EtatDemande updatedEtat = etatDemandeService.updateEtatDemande(id, updatedEtatDemande);

        if (updatedEtat != null) {
            return new ResponseEntity<>(updatedEtat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtatDemande(@PathVariable Long id) {
        boolean deleted = etatDemandeService.deleteEtatDemande(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
