package com.example.security.request;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.example.validation.ValidationConstrains.*;

public class RegisterRequest {

    @NotNull
    @Size(min = USERNAME_SIZE_MIN,max = USERNAME_SIZE_MAX)
    private String username;

    @NotNull
    @Size(min = PASSWORD_SIZE_MIN,max = PASSWORD_SIZE_MAX)
    private String password;

    @NotNull
    @Size(min = PASSWORD_SIZE_MIN,max = PASSWORD_SIZE_MAX)
    private String repeatedPassword;

    @NotNull
    @Email
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

    public String getRepeatedPassword() {
        return repeatedPassword;
    }
}
