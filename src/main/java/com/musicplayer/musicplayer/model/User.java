package com.musicplayer.musicplayer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

}


