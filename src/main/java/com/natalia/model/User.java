package com.natalia.model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String role;
    private String token;

    public User(int userId, String username, String password, String email, String role, String token) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public String setRole(String role) {
        return role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static User from(int userId, String username, String email) {
        return new User(userId, username, null, email, null, null);
    }
    public static User from(int userId, String username) {
        return new User(userId, username, null, null, null, null);
    }

    public static User from(int userId, String username, String password, String email, String role) {
        return new User(userId, username, password, email, role, null);
    }
    public static User from(int userId, String username, String password, String email) {
        return new User(userId, username, password, email, null, null);
    }
    public static User create(String username, String password, String email, String role, String token) {
        return new User(0, username, password, email, role, token);
    }
}
