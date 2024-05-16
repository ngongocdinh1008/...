package com.example.ceramicjbw.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname", nullable = false)
    private String username;

    @Column(name = "phone_number", nullable = false, length = 10)
    private String userPhone;

    @Column(nullable = false, length = 18)
    private String password;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "facebook_account_id")
    private int facebookAccountId;

    @Column(name = "google_account_id")
    private int googleAccountId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
