package com.musicplayer.musicplayer.controller;

import com.musicplayer.musicplayer.request.user.RegisterRequest;
import com.musicplayer.musicplayer.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    String register(@Valid @ModelAttribute("user") RegisterRequest request, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", request);
            return "/register";
        }

        userService.register(request);
        return "redirect:/register?success";

    }
}
