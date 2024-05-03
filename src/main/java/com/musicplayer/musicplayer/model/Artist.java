package com.musicplayer.musicplayer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs;

    @ManyToMany(mappedBy = "artists")
    private Set<Genre> genres = new HashSet<>();
}


