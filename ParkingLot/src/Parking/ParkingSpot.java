package Parking;

import Vehicle.Vehicle;
import Vehicle.VehicleType;

public class ParkingSpot {

    private final int spotNumber;
    private final VehicleType spotType;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int spotNumber, VehicleType spotType)
    {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public synchronized boolean isAvailable(){
        return !isOccupied;
    }

    public synchronized boolean park(Vehicle vehicle)
    {
        //change vehicletype to spottype
        if(isOccupied || vehicle.getType() != spotType){
            return false;
        }
        this.vehicle = vehicle;
        isOccupied =true;
        return true;
    }

    public synchronized void unpark(){
        vehicle = null;
        isOccupied = false;
    }

    public VehicleType getSpotType(){
        return spotType;
    }


    public Vehicle getVehicle(){
        return vehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
