package com.gti.ecredit.controllers;

import java.util.List;
import java.util.Optional;

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

import com.gti.ecredit.entities.AppUser;
import com.gti.ecredit.services.ClientService;

@RestController
@RequestMapping("/clients")
@CrossOrigin("${cross.origin.url}")
public class ClientController {
	@Autowired
    private ClientService clientService;

    @GetMapping
    public List<AppUser> getAllClients() {
    	
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getClientById(@PathVariable Long id) {
    	AppUser client = clientService.getClientById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/cin/{cin}")
    public ResponseEntity<AppUser> getClientByCin(@PathVariable Long cin) {
        Optional<AppUser> client = clientService.findClientByCin(cin);
        
        if (client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AppUser> createClient(@RequestBody AppUser client) {
    	AppUser createdClient = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateClient(@PathVariable Long id, @RequestBody AppUser updatedClient) {
    	AppUser client = clientService.updateClient(id, updatedClient);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (clientService.deleteClient(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
