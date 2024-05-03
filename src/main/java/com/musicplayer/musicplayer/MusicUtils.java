package com.musicplayer.musicplayer;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class MusicUtils {
    public static String extractArtistFromMusicFile(MultipartFile file) throws IOException {
        try {
            // Create a temporary file with the correct extension
            File tempFile = File.createTempFile("temp", ".mp3"); // Assuming MP3 files, adjust the extension as needed
            file.transferTo(tempFile);

            // Read metadata from the temporary file
            AudioFile audioFile = AudioFileIO.read(tempFile);
            String artist = audioFile.getTag().getFirst(FieldKey.ARTIST);

            // Delete the temporary file
            tempFile.delete();

            return artist != null ? artist : "Unknown";
        } catch (Exception e) {
            e.printStackTrace();
            return "Unknown";
        }
    }
}
