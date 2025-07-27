package org.example.Locker;

import org.example.Type;

public class LargeLocker extends Locker{

    Type lockerType = Type.LARGE;
    public LargeLocker(String id, boolean occupied) {
        super(id, occupied);
    }
}
