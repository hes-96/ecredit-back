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

import com.gti.ecredit.dto.CreditDto;
import com.gti.ecredit.entities.Credit;
import com.gti.ecredit.services.CreditService;

@RestController
@RequestMapping("/credits")
@CrossOrigin("${cross.origin.url}")
public class CreditController {
	@Autowired
    private CreditService creditService;

    @GetMapping
    public ResponseEntity<List<Credit>> getAllCredits() {
        List<Credit> credits = creditService.getAllCredits();
        return new ResponseEntity<>(credits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Credit> getCreditById(@PathVariable Long id) {
        Credit credit = creditService.getCreditById(id);
        return new ResponseEntity<>(credit, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Credit> createCredit(@RequestBody CreditDto creditDto) {
    	System.out.println(creditDto);
        Credit createdCredit = creditService.createCredit(creditDto);
        return new ResponseEntity<>(createdCredit, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Credit> updateCredit(@PathVariable Long id, @RequestBody CreditDto creditDto) {
        Credit updatedCredit = creditService.updateCredit(id, creditDto);
        return new ResponseEntity<>(updatedCredit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/updateToValide/{id}")
    Credit updateStatusToValide(@PathVariable Long id) {
    	System.out.println("validé");
    	return creditService.updateStatusToValide(id);
    }

    @PutMapping("/updateToRejete/{id}")
    Credit updateStatusToRejete(@PathVariable Long id) {
    	System.out.println("rejeté");
        return creditService.updateStatusToRejete(id);
    }

}
