package com.example.ceramicjbw.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @Column(name = "token_type")
    private String tokentype;

    @Column(name = "expiration_date")
    private LocalDateTime expires;

    private boolean revoked;

    private boolean exprired;

    @ManyToOne
    @JoinColumn(name = "user_id ")
    private User user;
}
