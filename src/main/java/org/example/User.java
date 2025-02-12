package org.example;

import java.security.PublicKey;
import java.util.UUID;

public class User {
    private String userID;
    private String userName;

    public User(String userName){
        this.userID = UUID.randomUUID().toString();
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }
}

