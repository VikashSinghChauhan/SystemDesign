package org.example;

public class User {
    String userId;
    String name;
    Wallet wallet;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet(userId+"W");
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }


}
