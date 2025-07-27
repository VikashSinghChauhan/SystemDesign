package org.example.Package;

public abstract class Package {
    String packageId;
    String userId;
    double weight;
    double volume;

    public Package(String packageId, String userId, double weight, double volume) {
        this.packageId = packageId;
        this.userId = userId;
        this.weight = weight;
        this.volume = volume;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getUserId() {
        return userId;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }
}
