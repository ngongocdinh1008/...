package com.example.ceramicjbw.repository;

import com.example.ceramicjbw.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    Keyword findByKeyword(String name);
}
