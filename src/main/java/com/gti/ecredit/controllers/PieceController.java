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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gti.ecredit.dto.PieceDto;
import com.gti.ecredit.entities.PieceJointe;
import com.gti.ecredit.services.PieceService;

@RestController
@RequestMapping("/pieces")
@CrossOrigin("${cross.origin.url}")
public class PieceController {
	@Autowired
    private PieceService pieceJointeService;

    @GetMapping
    public List<PieceJointe> getAllPieceJointes() {
        return pieceJointeService.getAllPieceJointes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PieceJointe> getPieceJointeById(@PathVariable Long id) {
        PieceJointe pieceJointe = pieceJointeService.getPieceJointeById(id);

        if (pieceJointe != null) {
            return new ResponseEntity<>(pieceJointe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /*@GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        PieceJointe pieceJointe = pieceJointeService.getPieceJointeById(id);

        if (pieceJointe == null) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = pieceJointeService.loadFileAsResource(pieceJointe.getDocUrl());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }*/
    
    @PostMapping("/{id}/upload")
    public String handleFileUpload(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
    	System.out.println("1");
        return pieceJointeService.uploadFile(file, id);
    }

    @PostMapping()
    public ResponseEntity<PieceJointe> addPieceJointe(@RequestBody PieceDto pieceDto) {
        System.out.println("1");
        PieceJointe newPieceJointe = pieceJointeService.addPieceJointeWithFile(pieceDto);
        return new ResponseEntity<>(newPieceJointe, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PieceJointe> updatePieceJointe(@PathVariable Long id, @RequestBody PieceJointe updatedPieceJointe) {
        PieceJointe updatedPieceJointeObj = pieceJointeService.updatePieceJointe(id, updatedPieceJointe);

        if (updatedPieceJointeObj != null) {
            return new ResponseEntity<>(updatedPieceJointeObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePieceJointe(@PathVariable Long id) {
        boolean deleted = pieceJointeService.deletePieceJointe(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
