package org.example.Package;

import org.example.Type;

public class LargePackage extends Package{

    Type type = Type.LARGE;
    public LargePackage(String packageId, String userId, double weight, double volume) {
        super(packageId, userId, weight, volume);
    }
}
