package org.example.ElevatorStrategy;

import org.example.Elevator;

import java.util.List;

public interface ElevatorStrategy {
    public void requestElevator(List<Elevator> elevatorList, int sourceFloor, int destinationFloor);
}
