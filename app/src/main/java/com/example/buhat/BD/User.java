package com.example.buhat.BD;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    private long id;
    private String login;

    private String password;

    private double rate;
    private static long countUser = 1;

    public User(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.rate = 0;
        countUser++;
    }

    public User(String login, String password) {
        this.id = countUser;
        this.login = login;
        this.password = password;
        this.rate = 0;
        countUser++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
