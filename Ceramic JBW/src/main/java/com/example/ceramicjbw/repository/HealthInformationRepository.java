package com.example.ceramicjbw.repository;

import com.example.ceramicjbw.entity.HealthInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthInformationRepository extends JpaRepository<HealthInformation, Long> {
}
