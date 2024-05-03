package com.musicplayer.musicplayer.service;

import com.musicplayer.musicplayer.model.Song;
import com.musicplayer.musicplayer.repository.SongRepo;
import com.musicplayer.musicplayer.request.song.uploadRequest;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final SongRepo songRepo;

    public SongService(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    public void upload(uploadRequest request){

    }
}
