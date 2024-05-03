package com.musicplayer.musicplayer.repository;

import com.musicplayer.musicplayer.model.Artist;
import com.musicplayer.musicplayer.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepo extends JpaRepository<Artist, Long> {
    Optional<Artist> findByName(String name);

}
