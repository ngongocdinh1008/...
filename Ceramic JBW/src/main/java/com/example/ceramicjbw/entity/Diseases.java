package com.example.ceramicjbw.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "diseases")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diseases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String information;

    private String cause;

    private String symptoms;

    private String object;

    @Column(name = "prevention_measures", nullable = false)
    private String PreventionMeasures;

    @Column(name = "kind", nullable = false)
    private String kind;

//    @OneToMany(mappedBy = "diseases")
//    private List<Keyword> keywords;

    private String priority;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
