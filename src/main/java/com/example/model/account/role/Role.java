package com.example.model.account.role;

public enum Role {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    CLIENT("ROLE_CLIENT"),
    EMPLOYEE("ROLE_EMPLOYEE");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
