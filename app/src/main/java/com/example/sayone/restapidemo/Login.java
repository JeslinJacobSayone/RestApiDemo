package com.example.sayone.restapidemo;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("user_name")
    String username;

    @SerializedName("password")
    String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
