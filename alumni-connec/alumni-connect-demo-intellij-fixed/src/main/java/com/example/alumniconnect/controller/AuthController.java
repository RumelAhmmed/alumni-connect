package com.example.alumniconnect.controller;

import com.example.alumniconnect.entity.User;
import com.example.alumniconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "auth/login"; // returns login.html
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/register"; // returns register.html
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already in use.");
            return "auth/register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER"); // Role will be prefixed with "ROLE_" in UserDetailsService
        userRepo.save(user);

        model.addAttribute("success", "Registration successful. Please login.");
        return "redirect:/auth/login";
    }
}
