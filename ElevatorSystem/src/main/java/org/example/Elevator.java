package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.example.Direction.UP;

public class Elevator {
    private int id;
    private int capacity;
    private int currentFloor;
    private Direction direction;
    private List<Request> requestList;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = 0;
        this.direction = UP;
        this.requestList = new ArrayList<>();
    }

    public synchronized void addRequest(Request request)
    {
        if(requestList.size() < capacity){
            requestList.add(request);
            System.out.println("Elevator "+id+" added reqeust : " + request.getSourceFloor());
            notifyAll();
        }
    }

    public synchronized Request getNextRequest(){
        while(requestList.isEmpty())
        {
            try{
                wait();
                /**
                 * Here wait() is redundant
                 * So by the time getNextRequest() is called, we already know the list is not empty —
                 * hence, the while(requestList.isEmpty()) block (and wait()) is unnecessary.
                 */
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        return requestList.remove(0);
    }

    public synchronized  void processRequests(){
        while(true)
        {
            while(!requestList.isEmpty())
            {
                Request request = getNextRequest();
                processRequest(request);
            }
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void processRequest(Request request)
    {
        int startFloor = currentFloor;
        int endFloor = request.getDestinationFloor();

        if(startFloor < endFloor)
        {
            direction = UP;
            for(int i=startFloor;i<=endFloor;i++)
            {
                currentFloor = i;
                System.out.println("Elevator "+id+" reached floor " + currentFloor);
                try{
                    Thread.sleep(1000); //simulating elevator movement

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }else if(startFloor > endFloor)
        {
            direction = Direction.DOWN;
            for(int i=startFloor;i>=endFloor;i--)
            {
                currentFloor = i;
                System.out.println("Elevator "+id+" reached floor " + currentFloor);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run(){
        processRequests();
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public Direction getDirection(){
        return direction;
    }

    public int getId(){
        return id;
    }
}
