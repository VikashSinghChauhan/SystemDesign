package org.example.Package;

import org.example.Type;

public class SmallPackage extends Package{

    Type type = Type.SMALL;
    public SmallPackage(String packageId, String userId, double weight, double volume) {
        super(packageId, userId, weight, volume);
    }
}
