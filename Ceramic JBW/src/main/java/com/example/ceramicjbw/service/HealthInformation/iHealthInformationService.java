package com.example.ceramicjbw.service.HealthInformation;

import com.example.ceramicjbw.dto.HealthInformationDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface iHealthInformationService {
    HealthInformationDTO createHealthInformation(HealthInformationDTO healthInformationDTO, MultipartFile imageFile) throws Exception;

    HealthInformationDTO getHealthInformationById(Long id) throws Exception;

    List<HealthInformationDTO> getAllHealthInformation() throws Exception;

    HealthInformationDTO updateHealthInformation(Long id, HealthInformationDTO healthInformationDTO) throws Exception;

    void deleteHealthInformation(Long id) throws Exception;
}
