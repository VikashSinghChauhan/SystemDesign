package org.example;

import org.example.Locker.Locker;
import org.example.Package.Package;

public class LockPackage {
    Locker locker;
    Package aPackage;
    String unlockCode;

    public LockPackage(Locker locker, Package aPackage, String unlockCode) {
        this.locker = locker;
        this.aPackage = aPackage;
        this.unlockCode = unlockCode;
    }

    public Locker getLocker() {
        return locker;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public String getUnlockCode() {
        return unlockCode;
    }
}
