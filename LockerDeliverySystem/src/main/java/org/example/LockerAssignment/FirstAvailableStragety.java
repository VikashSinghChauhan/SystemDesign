package org.example.LockerAssignment;

import org.example.Locker.Locker;
import org.example.Package.Package;

import java.util.List;

public class FirstAvailableStragety implements LockerAssignmentStrategy{
    @Override
    public Locker assignLocker(List<Locker> lockerList, Package pkg) {
        for(Locker locker : lockerList)
        {
            if(!locker.isOccupied())
            {
                return locker;
            }
        }
        return null;
    }
}
