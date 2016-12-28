package com.example.security.request;

public class RegisterRequest {

    private String username;
    private String password;
    private String mail;

    public RegisterRequest() {
    }

    public RegisterRequest(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }
}
