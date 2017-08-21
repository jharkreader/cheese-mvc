package org.launchcode.cheesemvc.models;

import java.util.Date;

public class User {

    private String username;
    private String email;
    private String password;
    private int userId;
    private Date joined;
    private static int nextUserId = 1;


    public User(String aUsername, String anEmail, String aPassword) {
        this.username = aUsername;
        this.email = anEmail;
        this.password = aPassword;
        this.userId = nextUserId;
        this.joined = new Date();
        nextUserId++;
    }

    public int getUserId() {
        return userId;
    }

    public Date getJoinedDate() {
        return joined;
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

}
