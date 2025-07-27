package org.example.Locker;

import org.example.Package.Package;
import org.example.Type;

public class SmallLocker extends Locker{

    Type lockerType = Type.SMALL;
    public SmallLocker(String id, boolean occupied) {
        super(id, occupied);
    }

}
