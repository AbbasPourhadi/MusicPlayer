package com.musicplayer.musicplayer.request.song;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class uploadRequest {
    @NotBlank
    private String song;

    @NotBlank
    @Length(min = 2)
    private String title;

}
