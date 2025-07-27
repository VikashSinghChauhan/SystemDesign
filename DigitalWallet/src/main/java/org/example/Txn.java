package org.example;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class Txn {

    String txnId;
    String fromWalletId;
    String toWalletId;
    long amount;
    Instant timestamp;
    TxnStatus  status;

    public Txn(String txnId, String fromWalletId, String toWalletId, long amount, TxnStatus status) {
        this.txnId = txnId;
        this.fromWalletId = fromWalletId;
        this.toWalletId = toWalletId;
        this.amount = amount;
        timestamp = Instant.now();
        this.status = status;
    }


    @Override
    public String toString() {
        return "Txn{" +
                "txnId='" + txnId + '\'' +
                ", fromWalletId='" + fromWalletId + '\'' +
                ", toWalletId='" + toWalletId + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", status=" + status +
                '}';
    }
}

enum TxnStatus{
    FAILED,
    SUCCESS
}
