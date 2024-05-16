package com.example.ceramicjbw.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "role")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
