package com.example.security.controller;

import com.example.exception.ValidationFailedException;
import com.example.model.account.User;
import com.example.model.account.role.Role;
import com.example.security.request.RegisterRequest;
import com.example.service.UserService;
import com.example.validation.validators.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.EnumSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    private RegisterValidator registerValidator;

    @Autowired
    public AuthenticationController(UserService userService, PasswordEncoder passwordEncoder, RegisterValidator registerValidator) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.registerValidator = registerValidator;
    }

    @InitBinder(value = "registerRequest")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(registerValidator);
    }

    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.OK)
    public void registerUser(@Valid @RequestBody RegisterRequest request, Errors errors) {

        if (errors.hasErrors()) throw new ValidationFailedException(errors);

        String hashedPassword = passwordEncoder.encode(request.getPassword());
        Set<Role> roles = EnumSet.of(Role.USER);
        roles.add(Role.USER);
        User user = new User(request.getUsername(), hashedPassword, request.getMail(), roles);
        userService.saveUser(user);
    }
}
