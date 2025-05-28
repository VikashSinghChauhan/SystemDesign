import Fee.VehicleBasedFeeStrategy;
import Parking.ParkingFloor;
import Parking.ParkingLot;
import Parking.ParkingSpot;
import Ticketing.Ticket;
import Vehicle.Car;
import Vehicle.VehicleType;
import Vehicle.Vehicle;
import Vehicle.*;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();
        List<ParkingSpot> parkingSpotsFloor1 = new ArrayList<>();
        {
            parkingSpotsFloor1.add(new ParkingSpot(101, VehicleType.CAR));
            parkingSpotsFloor1.add(new ParkingSpot(102, VehicleType.CAR));
            parkingSpotsFloor1.add(new ParkingSpot(103, VehicleType.BIKE));
        }

        List<ParkingSpot> parkingSpotsFloor2 = new ArrayList<>();
        {
            parkingSpotsFloor1.add(new ParkingSpot(201, VehicleType.BIKE));
            parkingSpotsFloor1.add(new ParkingSpot(202, VehicleType.TRUCK));
        }

        //Add a floor with different types of spots
        ParkingFloor floor1 = new ParkingFloor(1, parkingSpotsFloor1);
        ParkingFloor floor2 = new ParkingFloor(2, parkingSpotsFloor2);

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());

        //create Vehicles
         Vehicle car1 = new Car("ABC123");
         Vehicle car2 = new Car("XYZ123");
         Vehicle bike1 = new Bike("BYK123");


         //View available spots
        System.out.println("Available spots for car ::");
        for(ParkingFloor floor : parkingLot.getParkingFloors())
        {
            System.out.println("Floor : "+floor.getFloorNumber() + " " + floor.getAvailableSpot(VehicleType.CAR));
        }

        List<String> parkingTickets = new ArrayList<>();
        //park vehicles
        try{
            Ticket ticket1 = parkingLot.parkVehicle(car1);
            System.out.println("Car 1 parked: " + ticket1.getTicketId());
            parkingTickets.add(ticket1.getTicketId());

            Ticket ticket2 = parkingLot.parkVehicle(car2);
            System.out.println("Car 2 parked : " + ticket2.getTicketId());
            parkingTickets.add(ticket2.getTicketId());

            Ticket ticket3 = parkingLot.parkVehicle(bike1);
            System.out.println("Bike 1 parked : " + ticket3.getTicketId());
            parkingTickets.add(ticket3.getTicketId());

            //Try Parking another car when all spots full
            Vehicle car3 = new Car("DL098");
            parkingLot.parkVehicle(car3);

        }catch (Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }


        //unpark vehicles
        try{
            double fee = parkingLot.unparkVehicle(parkingTickets.get(0));
            System.out.println("Ticket : "+parkingTickets.get(0) + " , Fee: "+fee);
//            fee = parkingLot.unparkVehicle("1"); //invalid ticket id
            parkingTickets.remove(0);
            System.out.println(parkingTickets.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}