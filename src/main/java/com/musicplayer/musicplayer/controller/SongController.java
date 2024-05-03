package com.musicplayer.musicplayer.controller;

import com.musicplayer.musicplayer.MusicUtils;
import com.musicplayer.musicplayer.model.Artist;
import com.musicplayer.musicplayer.model.Genre;
import com.musicplayer.musicplayer.model.Song;
import com.musicplayer.musicplayer.repository.ArtistRepo;
import com.musicplayer.musicplayer.repository.GenreRepo;
import com.musicplayer.musicplayer.repository.SongRepo;
import com.musicplayer.musicplayer.request.song.uploadRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class SongController {
    private final SongRepo songRepo;
    private final ArtistRepo artistRepo;
    private final GenreRepo genreRepo;
    private static final String UPLOAD_DIR = "/src/main/resources/static/uploads/songs/";

    public SongController(SongRepo songRepo, ArtistRepo artistRepo, GenreRepo genreRepo) {
        this.songRepo = songRepo;
        this.artistRepo = artistRepo;
        this.genreRepo = genreRepo;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Song> songs = songRepo.findAll();
        model.addAttribute("songs", songs);
        return "index";
    }

    @GetMapping("/songs/upload")
    public String uploadForm() {
        return "add-song";
    }

    @PostMapping("/songs/upload")
    public String uploadSong(
            @RequestParam("artist") String artistName,
            @RequestParam("genre") String genreTitle,
            @RequestParam("song") MultipartFile file
    ) {
        try {
            Genre genre =genreRepo.findByTitle(genreTitle)
                    .orElseGet(() -> {
                        Genre newGenre = new Genre();
                        newGenre.setTitle(genreTitle);
                        return genreRepo.save(newGenre);
                    });

            Artist artist = artistRepo.findByName(artistName)
                    .orElseGet(() -> {
                        Artist newArtist = new Artist();
                        newArtist.setName(artistName);
                        return artistRepo.save(newArtist);
                    });

            Set<Genre> genres = new HashSet<>();
            genres.add(genre);
            artist.setGenres(genres);

            String filePath = System.getProperty("user.dir") +UPLOAD_DIR+ File.separator + file.getOriginalFilename();
            FileOutputStream fout = new FileOutputStream(filePath);
            fout.write(file.getBytes());
            fout.close();


            Song song = new Song();
           String filename = file.getOriginalFilename();
            int lastDotIndex = filename.lastIndexOf('.');
            if (lastDotIndex != -1) {
                 filename = filename.substring(0, lastDotIndex);
            }
            song.setTitle(filename);
            song.setPath(filePath.toString());
            song.setArtist(artist);
            song.setGenre(genre);
            songRepo.save(song);

            return "redirect:/";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }


}
