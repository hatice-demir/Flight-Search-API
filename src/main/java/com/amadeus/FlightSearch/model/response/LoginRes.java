package com.amadeus.FlightSearch.model.response;

public class LoginRes {
    private String userName;
    private String token;

    public LoginRes(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String email) {
        this.userName = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}