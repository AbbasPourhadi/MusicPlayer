package com.musicplayer.musicplayer.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank
    @Length(min = 3, max = 70)
    private String username;

    @NotBlank
    @Length(min = 6)
    private String password;

    @NotBlank
    @Email(message = "wrong email")
    private String email;
}
