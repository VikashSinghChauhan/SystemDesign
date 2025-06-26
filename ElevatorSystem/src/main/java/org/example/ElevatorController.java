package org.example;

import org.example.ElevatorStrategy.ElevatorStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.Direction.DOWN;
import static org.example.Direction.UP;

public class ElevatorController {

    private final List<Elevator> elevatorList;
    private ElevatorStrategy elevatorStrategy;

    public ElevatorController(int numElevators, int capacity, ElevatorStrategy elevatorStrategy) {
        this.elevatorList = new ArrayList<>();
        this.elevatorStrategy = elevatorStrategy;
        for(int i=0;i<numElevators;i++)
        {
            Elevator elevator = new Elevator(i+1, capacity);
            elevatorList.add(elevator);
            new Thread(elevator :: run).start();
        }
    }


    public void requestElevator(int sourceFloor, int destinationFloor) {
        elevatorStrategy.requestElevator(elevatorList, sourceFloor, destinationFloor);
    }


    public void currentStateOfElevators(){
        for(Elevator elevator : elevatorList)
        {
            System.out.println("Elevator "+elevator.getId() + " Standing at " + elevator.getCurrentFloor());
        }
    }


}
