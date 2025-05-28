package Parking;

import Vehicle.VehicleType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingFloor {

    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;


    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }


    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }


    public synchronized Optional<ParkingSpot> getAvailableSpot(VehicleType type)
    {
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getSpotType() == type)
                .findFirst();
    }

    public List<Integer> getAvailableSpots(VehicleType type){
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getSpotType()==type)
                //.map(spot-> spot.getSpotNumber())
                .map(Parking.ParkingSpot :: getSpotNumber)
                .collect(Collectors.toList());
    }

}
