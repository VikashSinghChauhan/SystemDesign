package org.example.Locker;

import org.example.Package.Package;

public abstract class Locker {
    private final String id;
    private boolean occupied;

    public Locker(String id, boolean occupied) {
        this.id = id;
        this.occupied = occupied;
    }

    public void occupy()
    {
        this.occupied= true;
    }

    public void release(){
        this.occupied = false;
    }

    public String getId() {
        return id;
    }

    public boolean isOccupied() {
        return occupied;
    }
}
