package com.example.ceramicjbw.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "social_accounts")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialAccounts {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String provider;

    private String email;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
