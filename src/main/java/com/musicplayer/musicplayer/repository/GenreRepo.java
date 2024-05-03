package com.musicplayer.musicplayer.repository;

import com.musicplayer.musicplayer.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepo extends JpaRepository<Genre, Long> {
    public Optional<Genre> findByTitle(String title);
}
