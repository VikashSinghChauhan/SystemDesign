package org.example;

import org.example.ElevatorStrategy.DirectionBasedStrategy;
import org.example.ElevatorStrategy.ElevatorStrategy;

public class ElevatorSystemDemo {
    public static void main(String[] args){
        ElevatorStrategy elevatorStrategy = new DirectionBasedStrategy();
        ElevatorController controller = new ElevatorController( 3,5, elevatorStrategy);
        controller.requestElevator(5,10);
        controller.requestElevator(3,7);
        controller.requestElevator(8,2);
        controller.requestElevator(1,9);
        controller.currentStateOfElevators();
    }
}
