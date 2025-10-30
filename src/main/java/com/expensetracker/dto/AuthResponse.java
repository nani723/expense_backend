package com.expensetracker.dto;

public class AuthResponse {

    private String token;
    private Long userId;
    private String name;
    private String email;
    private String type = "Bearer";

    // Constructors
    public AuthResponse() {
    }

    public AuthResponse(String token, Long userId, String name, String email, String type) {
        this.token = token;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.type = type;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
