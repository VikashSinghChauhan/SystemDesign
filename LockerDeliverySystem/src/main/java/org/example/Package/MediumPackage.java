package org.example.Package;

import org.example.Type;

public class MediumPackage extends Package{

    Type type = Type.MEDIUM;
    public MediumPackage(String packageId, String userId, double weight, double volume) {
        super(packageId, userId, weight, volume);
    }
}
