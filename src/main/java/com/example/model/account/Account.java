package com.example.model.account;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.stream.Collectors;

public class Account extends org.springframework.security.core.userdetails.User {

    public Account(User user) {
        super(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
                user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities()
                        .stream()
                        .map(e -> new SimpleGrantedAuthority(e.getRole()))
                        .collect(Collectors.toList()));

    }

}
