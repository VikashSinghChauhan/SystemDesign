package org.example;

import org.example.Locker.Locker;
import org.example.Locker.LockerFactory;
import org.example.Locker.SmallLocker;
import org.example.LockerAssignment.LockerAssignmentStrategy;
import org.example.Package.Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LockerService {
    private static LockerService instance;

    private final List<Locker> lockers = new ArrayList<>();
    private final Map<String, LockPackage> codeMap = new HashMap<>();

    private LockerService(){};

    public static LockerService getInstance()
    {
        if(instance == null)
        {
            return new LockerService();
        }
        return instance;
    }

    public void initializeLockers(int count){
        for(int i=1;i<=count;i++){
            lockers.add(LockerFactory.createLocker(Type.SMALL,"L"+i,false));
        }
    }

    public LockPackage assignLocker(Package pkg, LockerAssignmentStrategy strategy){
        Locker locker = strategy.assignLocker(lockers, pkg);
        if(locker == null)
            throw new RuntimeException("No Available locker");

        locker.occupy();
        String code = CodeGenerator.generate();
        LockPackage lockPackage = new LockPackage(locker, pkg, code);

        codeMap.put(code, lockPackage);
        System.out.println("Notification to user :" + pkg.getUserId() + ": Package placed in locker "
                             + locker.getId() + " with code : " + code);
        return lockPackage;
    }

    public void collectPackage(String code){
        LockPackage lockPackage = codeMap.get(code);
        if(lockPackage == null)throw new RuntimeException("Invalid code");
        lockPackage.getLocker().release();
        System.out.println("Package collected from locker: " + lockPackage.getLocker().getId());
    }
}
