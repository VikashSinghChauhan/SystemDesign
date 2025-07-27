package org.example;

import org.example.LockerAssignment.FirstAvailableStragety;
import org.example.LockerAssignment.LockerAssignmentStrategy;
import org.example.Package.Package;
import org.example.Package.PackageFactory;

public class Main {
    public static void main(String[] args) {
        LockerService lockerService = LockerService.getInstance();
        lockerService.initializeLockers(10);

        Package pkg = PackageFactory.createPackage(Type.SMALL,"P1", "123", 12, 12);

        LockerAssignmentStrategy lockerAssignmentStrategy = new FirstAvailableStragety();
        LockPackage lockPackage = lockerService.assignLocker(pkg,lockerAssignmentStrategy);
        lockerService.collectPackage(lockPackage.getUnlockCode());
    }
}