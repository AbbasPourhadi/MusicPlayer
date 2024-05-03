package com.musicplayer.musicplayer.controller;

import com.musicplayer.musicplayer.request.user.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new RegisterRequest());
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
