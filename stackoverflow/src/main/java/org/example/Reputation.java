package org.example;

public enum Reputation {

    QUE(5),
    ANS(10),
    COMMENT(2);

    int val;

    Reputation(int x)
    {
        this.val = x;
    }

    public int getVal() {
        return val;
    }
}
