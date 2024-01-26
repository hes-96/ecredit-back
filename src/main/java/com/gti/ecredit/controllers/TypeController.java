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

import com.gti.ecredit.entities.TypeCredit;
import com.gti.ecredit.services.TypeService;

@RestController
@RequestMapping("/types")
@CrossOrigin("${cross.origin.url}")
public class TypeController {
	@Autowired
    private TypeService typeCreditService;

    @GetMapping
    public List<TypeCredit> getAllTypeCredits() {
        return typeCreditService.getAllTypeCredits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeCredit> getTypeCreditById(@PathVariable Long id) {
        TypeCredit typeCredit = typeCreditService.getTypeCreditById(id);

        if (typeCredit != null) {
            return new ResponseEntity<>(typeCredit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TypeCredit> createTypeCredit(@RequestBody TypeCredit typeCredit) {
        TypeCredit createdTypeCredit = typeCreditService.createTypeCredit(typeCredit);
        return new ResponseEntity<>(createdTypeCredit, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCredit> updateTypeCredit(@PathVariable Long id, @RequestBody TypeCredit updatedTypeCredit) {
        TypeCredit updatedTypeCreditObj = typeCreditService.updateTypeCredit(id, updatedTypeCredit);

        if (updatedTypeCreditObj != null) {
            return new ResponseEntity<>(updatedTypeCreditObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeCredit(@PathVariable Long id) {
        boolean deleted = typeCreditService.deleteTypeCredit(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
