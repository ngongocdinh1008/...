package com.example.ceramicjbw.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
}
