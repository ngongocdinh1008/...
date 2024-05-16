package com.example.ceramicjbw.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "health_information")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "health_information_id ")
    private Long healthinformationIds;

    private String name;

    @Lob
    private byte[] image;

    private String information;

    private String category;

    @ManyToMany
    @JoinTable(
            name = "healthinformation_keyword",
            joinColumns = @JoinColumn(name = "health_information_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id")
    )
    private List<Keyword> keywords;


    @OneToMany(mappedBy = "healthInformation", cascade = CascadeType.ALL)
    private List<Details> details;
}
