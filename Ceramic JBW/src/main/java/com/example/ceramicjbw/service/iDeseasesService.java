package com.example.ceramicjbw.service;

import com.example.ceramicjbw.entity.Diseases;

import java.util.List;

public interface iDeseasesService {
    Diseases createDiseases(Diseases diseases);

    Diseases getDiseasesById(long id);

    List<Diseases> getAllDiseases();

    Diseases updateDiseases(long id, Diseases diseases);

    void deleteDiseases(long id);
}
