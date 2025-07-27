package org.example;

import java.util.HashMap;

public class WalletService {

    static HashMap<String , User> userHashMap = new HashMap<>();
    static WalletService instance=null;

    private WalletService(){}

    public static WalletService getInstance(){
        if(instance!=null) {
            return instance;
        } else {
            instance = new WalletService();
            userHashMap = new HashMap<>();
            return instance;
        }
    }

    public User createUser(String userId, String name){
        User user = new User(userId, name );
        userHashMap.put(userId, user);
        return user;
    }

    public boolean transferFund(String userIdTo, long amount, User userFrom)
    {
        User userTo = userHashMap.getOrDefault(userIdTo, null);
        if(userTo == null)
        {
            System.out.println("No Such user with userId " + userIdTo + " exits");
            return false;
        }
        else
        {
            if(userFrom.getWallet().deductFund(amount, userIdTo) &&
            userTo.getWallet().addFunds(userFrom.getWallet().walletId, amount)) return true;
            else return false;
        }
    }

    public boolean addFunds(User userId, long amount)
    {
        userId.getWallet().addFunds(userId.getWallet().walletId, amount);
        return true;
    }




}
