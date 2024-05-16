package com.example.ceramicjbw.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "health_information_keyword")
public class HealthInformationKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "health_information_id")
    private HealthInformation healthInformation;

    @ManyToOne
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;
}
