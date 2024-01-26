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

import com.gti.ecredit.entities.Unite;
import com.gti.ecredit.services.UniteService;

@RestController
@RequestMapping("/unites")
@CrossOrigin("${cross.origin.url}")
public class UniteController {
	@Autowired
    private UniteService uniteService;

    @GetMapping
    public List<Unite> getAllUnites() {
        return uniteService.getAllUnites();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unite> getUniteById(@PathVariable Long id) {
        Unite unite = uniteService.getUniteById(id);

        if (unite != null) {
            return new ResponseEntity<>(unite, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Unite> createUnite(@RequestBody Unite unite) {
        Unite createdUnite = uniteService.createUnite(unite);
        return new ResponseEntity<>(createdUnite, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unite> updateUnite(@PathVariable Long id, @RequestBody Unite updatedUnite) {
        Unite updatedUniteObj = uniteService.updateUnite(id, updatedUnite);

        if (updatedUniteObj != null) {
            return new ResponseEntity<>(updatedUniteObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnite(@PathVariable Long id) {
        boolean deleted = uniteService.deleteUnite(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
