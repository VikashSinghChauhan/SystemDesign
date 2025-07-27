package org.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    String walletId;
    long balance;
    List<Txn> txnList;

    public Wallet(String walletId) {
        this.walletId = walletId;
        this.balance = 0;
        this.txnList = new ArrayList<>();
    }

    public synchronized  boolean addFunds(String fromWalletId, long amount)
    {
        balance += amount;
        Txn txn = new Txn(walletId + Instant.now().toEpochMilli(),fromWalletId, walletId, amount, TxnStatus.SUCCESS);
        txnList.add(txn);
        return true;
    }

    public synchronized boolean deductFund(long amount, String toWalletId)
    {
        if(balance >= amount)
        {
            balance -= amount;
            Txn txn = new Txn(walletId + Instant.now().toEpochMilli(),walletId, toWalletId, amount, TxnStatus.SUCCESS);
            txnList.add(txn);
            System.out.println("Amount deducted : " + amount +  " || remaining balance : " + balance);
            return true;
        }
        else
        {
            System.out.println("Insufficient balance : " + balance);
            Txn txn = new Txn(walletId + Instant.now().toEpochMilli(),walletId, toWalletId, amount, TxnStatus.FAILED);
            txnList.add(txn);
            return false;
        }

    }

}
