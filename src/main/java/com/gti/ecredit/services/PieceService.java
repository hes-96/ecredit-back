package com.gti.ecredit.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gti.ecredit.dto.PieceDto;
import com.gti.ecredit.entities.Credit;
import com.gti.ecredit.entities.PieceJointe;
import com.gti.ecredit.repositories.CreditRepo;
import com.gti.ecredit.repositories.PieceRepo;

@Service
@Transactional
public class PieceService {
	@Autowired
    private PieceRepo pieceJointeRepository;
	
	@Autowired
    private CreditRepo creditRepository;


    public List<PieceJointe> getAllPieceJointes() {
        return pieceJointeRepository.findAll();
    }

    public PieceJointe getPieceJointeById(Long id) {
        return pieceJointeRepository.findById(id).orElse(null);
    }

    public PieceJointe addPieceJointeWithFile(/*MultipartFile file*/PieceDto pieceDto) {
        /*System.out.println("2");
        PieceJointe pieceJointe = new PieceJointe();
        pieceJointe.setObligatoire(obligatoire);

        // Call a method to handle file upload and set docUrl
        String filePath = uploadFile(file, documentName);

        pieceJointe.setDocUrl(filePath);
        System.out.println("3");*/
    	
    	PieceJointe piece = convertToEntity(pieceDto);

        // Check if the Credit with the provided creditId exists
        Credit credit = creditRepository.findById(pieceDto.getCreditId())
                .orElseThrow(() -> new EntityNotFoundException("Credit not found with id: " + pieceDto.getCreditId()));
        piece.setCredit(credit);
        return pieceJointeRepository.save(piece);
    }
    
    private PieceJointe convertToEntity(PieceDto pieceDto) {
    	PieceJointe piece = new PieceJointe();
        piece.setDocument(pieceDto.getDocument());
        piece.setObligatoire(pieceDto.isObligatoire());
        return piece;
    }

    public String uploadFile(MultipartFile file, Long id) {
    	System.out.println("2");
        PieceJointe piece = pieceJointeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Credit not found with id: " + id));

        // Implement your file upload logic here
        // You can use libraries like Apache Commons FileUpload or Spring's MultipartFile methods

        // For simplicity, let's assume you are saving the file in a "uploads" folder in your project
        String uploadsDir = "uploads";
        String fileName = UUID.randomUUID().toString() + "_" + id;

        try {
            Path uploadPath = Paths.get(uploadsDir);

            // Create the "uploads" folder if it doesn't exist
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Set the docUrl attribute for the PieceJointe entity with the whole file path
            String fileAbsolutePath = filePath.toAbsolutePath().toString();
            piece.setDocUrl(fileAbsolutePath);
            pieceJointeRepository.save(piece); // Save the updated entity

            return fileAbsolutePath;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file: " + fileName, e);
        }
    }

    
    /*public Resource loadFileAsResource(String filePath) {
        try {
            Path path = Paths.get(filePath);
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("File not found or is not readable: " + filePath);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL: " + filePath, e);
        }
    }*/

    public PieceJointe updatePieceJointe(Long id, PieceJointe updatedPieceJointe) {
        if (pieceJointeRepository.existsById(id)) {
            updatedPieceJointe.setId(id);
            return pieceJointeRepository.save(updatedPieceJointe);
        } else {
            return null; // PieceJointe not found
        }
    }

    public boolean deletePieceJointe(Long id) {
        if (pieceJointeRepository.existsById(id)) {
            pieceJointeRepository.deleteById(id);
            return true;
        } else {
            return false; // PieceJointe not found
        }
    }
}
