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

import com.gti.ecredit.dto.GarantieDto;
import com.gti.ecredit.entities.Garantie;
import com.gti.ecredit.services.GarantieService;

@RestController
@RequestMapping("/garanties")
@CrossOrigin("${cross.origin.url}")
public class GarantieController {
	@Autowired
    private GarantieService garantieService;

    @GetMapping
    public List<Garantie> getAllGaranties() {
        return garantieService.getAllGaranties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Garantie> getGarantieById(@PathVariable Long id) {
        Garantie garantie = garantieService.getGarantieById(id);

        if (garantie != null) {
            return new ResponseEntity<>(garantie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Garantie> addGarantie(@RequestBody GarantieDto garantieDto) {
        Garantie newGarantie = garantieService.addGarantie(garantieDto);
        return new ResponseEntity<>(newGarantie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Garantie> updateGarantie(@PathVariable Long id, @RequestBody GarantieDto updatedGarantieDto) {
        Garantie updatedGarantie = garantieService.updateGarantie(id, updatedGarantieDto);
        if (updatedGarantie != null) {
            return new ResponseEntity<>(updatedGarantie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarantie(@PathVariable Long id) {
        boolean deleted = garantieService.deleteGarantie(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
