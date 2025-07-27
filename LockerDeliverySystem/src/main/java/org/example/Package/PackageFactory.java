package org.example.Package;

import org.example.Package.LargePackage;
import org.example.Package.MediumPackage;
import org.example.Package.Package;
import org.example.Package.SmallPackage;
import org.example.Type;

public class PackageFactory {
    public static Package createPackage(Type type, String id, String userid, double weight, double volume)
    {
        switch (type){
            case SMALL:
                return new SmallPackage(id, userid, weight, volume);
            case MEDIUM:
                return new MediumPackage(id, userid, weight, volume);
            case LARGE:
                return new LargePackage(id, userid, weight, volume);
            default:
                System.out.println("Type "+type + " undefined");
                return null;
        }
    }
}
