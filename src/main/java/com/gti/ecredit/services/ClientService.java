package com.gti.ecredit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.ecredit.entities.AppUser;
import com.gti.ecredit.entities.Role;
import com.gti.ecredit.repositories.ClientRepo;

@Service
@Transactional
public class ClientService {
	@Autowired
    private ClientRepo clientRepository;

	public List<AppUser> getAllClients() {
	    List<AppUser> clients = clientRepository.findAll();
	    /*List<AppUser> filteredClients = new ArrayList<AppUser>();
	    clients.forEach(client -> {
	    	Set<Role> roles = client.getRoles();
	    	roles.forEach(role -> {
	    		if(role.getName()=="ROLE_CLIENT")
	    			filteredClients.add(client);
	    	});
	    });*/

	    return clients.stream()
	            .filter(user -> {
	                boolean hasClientRole = user.getRoles().stream()
	                        .anyMatch(role -> {
	                            System.out.println("User: " + user.getUsername() + ", Role: " + role.getName());
	                            System.out.println("ROLE_CLIENT".equals(role.getName()));
	                            return "ROLE_CLIENT".equals(role.getName());
	                        });
	                return hasClientRole;
	            })
	            .collect(Collectors.toList());
	}


    public AppUser getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
    
    public Optional<AppUser> findClientByCin(Long cin) {
        return clientRepository.findByCin(cin);
    }

    public AppUser createClient(AppUser client) {
        return clientRepository.save(client);
    }

    public AppUser updateClient(Long id, AppUser updatedClient) {
        if (clientRepository.existsById(id)) {
            updatedClient.setId(id);
            return clientRepository.save(updatedClient);
        } else {
            return null; // Client not found
        }
    }

    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        } else {
            return false; // Client not found
        }
    }
    
    
}
