package com.example.ceramicjbw.controller;

import com.example.ceramicjbw.dto.HealthInformationDTO;
import com.example.ceramicjbw.service.HealthInformation.HealthInformationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/health-information") //http://localhost:1111/api/v1/health-information
@AllArgsConstructor
public class HealthInformationController {
    @Autowired
    private final HealthInformationService healthInformationService;

    @PostMapping("/create")
    public ResponseEntity<?> createHealthInformation(@RequestParam("image") MultipartFile imageFile,
                                                     @RequestParam("healthInformationDTO") String healthInformationDTOJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            HealthInformationDTO healthInformationDTO = objectMapper.readValue(healthInformationDTOJson, HealthInformationDTO.class);

            HealthInformationDTO createdHealthInformation = healthInformationService.createHealthInformation(healthInformationDTO, imageFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdHealthInformation);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create health information: " + e.getMessage());
        }
    }


    @GetMapping("/{id}") //http://localhost:1111/api/v1/health-information/{id}
    public ResponseEntity<?> getHealthInformationById(@PathVariable("id") Long id) {
        try {
            HealthInformationDTO healthInformationDTO = healthInformationService.getHealthInformationById(id);
            return new ResponseEntity<>(healthInformationDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")//http://localhost:1111/api/v1/health-information/all
    public ResponseEntity<?> getAllHealthInformation() {
        try {
            List<HealthInformationDTO> healthInformationDTOs = healthInformationService.getAllHealthInformation();
            return new ResponseEntity<>(healthInformationDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")//http://localhost:1111/api/v1/health-information/{id}
    public ResponseEntity<?> updateHealthInformation(@PathVariable("id") Long healthInformationId, @RequestBody HealthInformationDTO healthInformationDTO) {
        try {
            HealthInformationDTO updatedHealthInformation = healthInformationService.updateHealthInformation(healthInformationId, healthInformationDTO);
            return ResponseEntity.ok(updatedHealthInformation);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")//http://localhost:1111/api/v1/health-information/{id}
    public ResponseEntity<?> deleteHealthInformation(@PathVariable("id") Long id) {
        try {
            healthInformationService.deleteHealthInformation(id);
            return new ResponseEntity<>("HealthInformation deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
