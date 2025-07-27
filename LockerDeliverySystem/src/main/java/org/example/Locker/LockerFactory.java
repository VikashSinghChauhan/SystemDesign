package org.example.Locker;

import org.example.Locker.LargeLocker;
import org.example.Locker.Locker;
import org.example.Locker.MediumLocker;
import org.example.Locker.SmallLocker;
import org.example.Type;

public class LockerFactory {
    public static Locker createLocker(Type type, String id, boolean occupied)
    {
        switch (type){
            case SMALL:
                return new SmallLocker(id, occupied);
            case MEDIUM:
                return new MediumLocker(id, occupied);
            case LARGE:
                return new LargeLocker(id, occupied);
            default:
                System.out.println("Type "+type + " undefined");
                return null;
        }
    }
}
