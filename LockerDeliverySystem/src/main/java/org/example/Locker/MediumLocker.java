package org.example.Locker;

import org.example.Type;

public class MediumLocker extends Locker{
    Type lockerType = Type.MEDIUM;
    public MediumLocker(String id, boolean occupied) {
        super(id, occupied);
    }
}
