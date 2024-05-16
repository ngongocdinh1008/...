//package com.example.ceramicjbw.service;
//
//import com.example.ceramicjbw.dto.DiseasesDTO;
//import com.example.ceramicjbw.entity.Diseases;
//import com.example.ceramicjbw.repository.DiseasesRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class DiseasesService implements iDeseasesService{
//
//    private final DiseasesRepository diseasesRepository;
//
//    private DiseasesDTO diseasesDTO;
//
//
//    @Override
//    public Diseases createDiseases(Diseases diseases) {
//        return diseasesRepository.save(diseases);
//    }
//
//    @Override
//    public Diseases getDiseasesById(long id) {
//        return diseasesRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Diseases not found"));
//    }
//
//    @Override
//    public List<Diseases> getAllDiseases() {
//        return diseasesRepository.findAll();
//    }
//
//    @Override
//    public Diseases updateDiseases(long id, Diseases diseases) {
//        Diseases existingDiseases = getDiseasesById(id);
//        return existingDiseases;
//
//    }
//    @Override
//    public void deleteDiseases(long id) {
//        diseasesRepository.deleteById(id);
//    }
//}
