package org.example;

public class Main {
    public static void main(String[] args) {

        WalletService walletService = WalletService.getInstance();
        User ram = walletService.createUser("1", "Ram");
        User shyam = walletService.createUser("2","Shyam");

        walletService.addFunds(ram, 200);
        walletService.transferFund(shyam.getUserId(), 100, ram);

        for(Txn txn : ram.getWallet().txnList)
        {
            System.out.println(txn.toString());
        }
    }
}