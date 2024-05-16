package com.example.ceramicjbw.repository;

import com.example.ceramicjbw.entity.Diseases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseasesRepository extends JpaRepository<Diseases, Long> {
}
