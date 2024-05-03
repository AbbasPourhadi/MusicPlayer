package com.musicplayer.musicplayer.repository;

import com.musicplayer.musicplayer.model.Song;
import com.musicplayer.musicplayer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepo extends JpaRepository<Song, Long> {
    Optional<Song> findByTitle(String title);
}
