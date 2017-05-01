package com.example.service;

import com.example.model.account.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getAuthenticatedUser(Authentication authentication) {
        return findUserByUsername(authentication.getName());
    }


}
