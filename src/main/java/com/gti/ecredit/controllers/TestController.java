package com.gti.ecredit.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "${cross.origin.url}", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/client")
	@PreAuthorize("hasRole('CLIENT')")
	public String userAccess() {
		return "Client Content.";
	}

	@GetMapping("/charge")
	@PreAuthorize("hasRole('CHARGE')")
	public String moderatorAccess() {
		return "Charge Board.";
	}
}
