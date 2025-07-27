package org.example.LockerAssignment;

import org.example.Locker.Locker;
import org.example.Package.Package;

import java.util.List;

public interface LockerAssignmentStrategy {
    Locker assignLocker(List<Locker> lockerList, Package pkg);
}
