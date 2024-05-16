package com.example.ceramicjbw.service.HealthInformation;

import com.example.ceramicjbw.dto.HealthInformationDTO;
import com.example.ceramicjbw.entity.*;
import com.example.ceramicjbw.repository.HealthInformationRepository;
import com.example.ceramicjbw.repository.KeywordRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HealthInformationService implements iHealthInformationService {

    @Autowired
    private HealthInformationRepository healthInformationRepository;

    @Autowired
    private KeywordRepository keywordRepository;

    @Autowired
    private ModelMapper modelMapper;
    /*------------------------------------------------Create----------------------------------------------------*/
    @Transactional
    public HealthInformationDTO createHealthInformation(HealthInformationDTO healthInformationDTO, MultipartFile imageFile) throws IOException {
        HealthInformation healthInformation = convertToEntity(healthInformationDTO, imageFile);
        HealthInformation savedHealthInformation = healthInformationRepository.save(healthInformation);
        return convertToDTO(savedHealthInformation);
    }

    private HealthInformationDTO convertToDTO(HealthInformation healthInformation) {
        return modelMapper.map(healthInformation, HealthInformationDTO.class);
    }

    private HealthInformation convertToEntity(HealthInformationDTO healthInformationDTO, MultipartFile imageFile) throws IOException {
        HealthInformation healthInformation = modelMapper.map(healthInformationDTO, HealthInformation.class);

        // Set image data from uploaded file
        healthInformation.setImage(imageFile.getBytes());

        /*---------------------------------Key Word ----------------------------------*/
        if (healthInformationDTO.getKeyword() != null) {
            List<Keyword> existingKeywords = new ArrayList<>();
            List<Keyword> newKeywords = new ArrayList<>();
            for (String keywordName : healthInformationDTO.getKeyword()) {
                Keyword keyword = keywordRepository.findByKeyword(keywordName);
                if (keyword != null) {
                    existingKeywords.add(keyword);
                } else {
                    Keyword newKeyword = new Keyword();
                    newKeyword.setKeyword(keywordName);
                    newKeywords.add(newKeyword);
                }
            }
            if (!newKeywords.isEmpty()) {
                keywordRepository.saveAll(newKeywords);
            }
            List<Keyword> allKeywords = new ArrayList<>();
            allKeywords.addAll(existingKeywords);
            allKeywords.addAll(newKeywords);
            healthInformation.setKeywords(allKeywords);
        }
        /*------------------------------Details------------------------------*/
        healthInformation.setDetails(healthInformationDTO.getDetails().stream()
                .map(detailDTO -> new Details(detailDTO.getId(), detailDTO.getTitle(), detailDTO.getInformation(), healthInformation))
                .collect(Collectors.toList()));

        return healthInformation;
    }

    /*------------------------------------------------Get---------------------------------------------------------*/
    @Override
    public HealthInformationDTO getHealthInformationById(Long id) throws Exception {
        try {
            HealthInformation healthInformation = healthInformationRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không tìm thấy thông Tin sức khỏe với id : " + id));
            return modelMapper.map(healthInformation, HealthInformationDTO.class);
        } catch (Exception e) {
            throw new Exception("Đã xảy ra lỗi khi truy xuất Thông tin sức khỏe theo id: " + id, e);
        }
    }
    /*------------------------------------------------Get All-----------------------------------------------------*/
    @Override
    public List<HealthInformationDTO> getAllHealthInformation() throws Exception {
        try {
            List<HealthInformation> healthInformations = healthInformationRepository.findAll();
            List<HealthInformationDTO> healthInformationDTOs = new ArrayList<>();

            for (HealthInformation healthInformation : healthInformations) {
                HealthInformationDTO healthInformationDTO = convertToDTOWithKeywords(healthInformation);
                healthInformationDTOs.add(healthInformationDTO);
            }

            return healthInformationDTOs;
        } catch (Exception e) {
            throw new Exception("Đã xảy ra lỗi khi truy xuất tất cả Thông tin sức khỏe", e);
        }
    }

    private HealthInformationDTO convertToDTOWithKeywords(HealthInformation healthInformation) {
        HealthInformationDTO healthInformationDTO = modelMapper.map(healthInformation, HealthInformationDTO.class);
        List<String> keywords = healthInformation.getKeywords().stream()
                .map(Keyword::getKeyword)
                .collect(Collectors.toList());
        healthInformationDTO.setKeyword(keywords);
        return healthInformationDTO;
    }
    /*------------------------------------------------Update----------------------------------------------------*/
    @Override
    public HealthInformationDTO updateHealthInformation(Long healthInformationId, HealthInformationDTO
            healthInformationDTO) {
        HealthInformation existingHealthInformation = healthInformationRepository.findById(healthInformationId)
                .orElseThrow(() -> new RuntimeException("HealthInformation not found with id: " + healthInformationId));

        // Update thông tin của existingHealthInformation với thông tin từ healthInformationDTO
        existingHealthInformation.setName(healthInformationDTO.getName());
        existingHealthInformation.setInformation(healthInformationDTO.getInformation());

        // Cập nhật Details
        List<Details> updatedDetails = healthInformationDTO.getDetails().stream()
                .map(detailDTO -> new Details(detailDTO.getId(), detailDTO.getTitle(), detailDTO.getInformation(), existingHealthInformation))
                .collect(Collectors.toList());
        existingHealthInformation.setDetails(updatedDetails);

        // Lưu lại thông tin đã cập nhật vào cơ sở dữ liệu
        HealthInformation savedHealthInformation = healthInformationRepository.save(existingHealthInformation);
        return convertToHealthInformationDTO(savedHealthInformation);
    }

    private HealthInformationDTO convertToHealthInformationDTO(HealthInformation healthInformation) {
        return modelMapper.map(healthInformation, HealthInformationDTO.class);
    }

    private HealthInformation convertToHealthInformationEntity(HealthInformationDTO healthInformationDTO) {
        HealthInformation healthInformation = modelMapper.map(healthInformationDTO, HealthInformation.class);
        healthInformation.setDetails(healthInformationDTO.getDetails().stream()
                .map(detailDTO -> new Details(detailDTO.getId(), detailDTO.getTitle(), detailDTO.getInformation(), healthInformation))
                .collect(Collectors.toList()));
        return healthInformation;
    }
    /*------------------------------------------------Delete-------------------------------------------------------*/
    @Override
    public void deleteHealthInformation(Long id) throws Exception {
        try {
            healthInformationRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Đã xảy ra lỗi khi xóa Thông tin sức khỏe có id:" + id, e);
        }
    }
}

