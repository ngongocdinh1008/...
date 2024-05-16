package com.example.ceramicjbw.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "diseases_images")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiseasesImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image_url")
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "diseases_id")
    private Diseases diseases;
}
