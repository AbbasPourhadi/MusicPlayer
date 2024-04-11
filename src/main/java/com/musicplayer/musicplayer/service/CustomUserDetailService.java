package com.musicplayer.musicplayer.service;

import com.musicplayer.musicplayer.model.User;
import com.musicplayer.musicplayer.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepo userRepo;

    public CustomUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isPresent()){
            var userObject = user.get();
          return org.springframework.security.core.userdetails.User.builder()
                    .username(userObject.getUsername())
                    .password(userObject.getPassword())
                    .build();

        }else {
            throw new UsernameNotFoundException(username);
        }

    }
}
