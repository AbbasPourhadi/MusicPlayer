package com.musicplayer.musicplayer.service;

import com.musicplayer.musicplayer.model.User;
import com.musicplayer.musicplayer.repository.UserRepo;
import com.musicplayer.musicplayer.request.user.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        userRepo.save(user);
    }
}
