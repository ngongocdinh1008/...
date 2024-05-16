package com.example.ceramicjbw.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "keyword")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private Long keywordIds;

    private String keyword;

    @ManyToMany(mappedBy = "keywords")
    private List<HealthInformation> healthInformations;

}
