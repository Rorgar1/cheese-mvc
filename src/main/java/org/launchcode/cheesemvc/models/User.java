package org.launchcode.cheesemvc.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 15)
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    private static int nextId = 0;

    public User() {
        updateNextId();
        this.id = nextId;
    }

    private static void updateNextId() {
        nextId = nextId++;
    }

    public int getId() {
        return id;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public User setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
        return this;
    }

    private void checkPassword() {
        if (password != null && verifyPassword != null && !verifyPassword.equals(password)) {
            verifyPassword = null;
        }
    }
}
