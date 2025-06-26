package org.example.ElevatorStrategy;

import org.example.Direction;
import org.example.Elevator;
import org.example.Request;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.Direction.DOWN;
import static org.example.Direction.UP;

public class DirectionBasedStrategy implements ElevatorStrategy{

    @Override
    public void requestElevator(List<Elevator> elevatorList, int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = findOptimalElevator(elevatorList, sourceFloor, destinationFloor);
        optimalElevator.addRequest(new Request(sourceFloor, destinationFloor));
    }




    private Elevator findOptimalElevator(List<Elevator> elevatorList, int sourceFloor, int destinationFloor)
    {
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;

        //first preference to direction
        Direction userDirection = (sourceFloor - destinationFloor) > 0 ?DOWN : UP;

        //anyMatch() -> returns true if any one element of the stream matches the given predicate.
        // Stop processing as soon as it finds the first match (short-circuiting behavior).
        List<Elevator> optimalElevators = elevatorList.stream().anyMatch(e->e.getDirection() == userDirection) ?
                elevatorList.stream().filter(e->e.getDirection() == userDirection).collect(Collectors.toList()) : elevatorList;

        for(Elevator elevator : optimalElevators){
            int distance = Math.abs(sourceFloor - elevator.getCurrentFloor());
            if(distance < minDistance){
                minDistance = distance;
                optimalElevator = elevator;
            }
        }
        return optimalElevator;
    }
}
