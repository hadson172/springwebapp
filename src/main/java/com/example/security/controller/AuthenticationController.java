package com.example.security.controller;

import com.example.model.account.User;
import com.example.model.account.role.Role;
import com.example.security.request.RegisterRequest;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterRequest request) {

        String hashedPassword = passwordEncoder.encode(request.getPassword());
        Set<Role> roles = EnumSet.of(Role.USER);
        roles.add(Role.USER);
        User user = new User(request.getUsername(), hashedPassword, request.getMail(), roles);

        userService.saveUser(user);
    }
}
