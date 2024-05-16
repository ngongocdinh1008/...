package com.example.ceramicjbw.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "details")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String information;

    @ManyToOne
    @JoinColumn(name = "health_information_id")
    private HealthInformation healthInformation;
}
