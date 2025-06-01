package Observer2;

import Logging1.LogMessage1;

import java.util.*;


public class Subject1 {

    List<Observer2> observers = new ArrayList<>();

    public void addObserver( Observer2 logObserver){
        observers.add(logObserver);
    }

    public void removeObserver(Observer2 logObserver)
    {

        observers.remove(logObserver);
    }

    public void notifyAllObserver(LogMessage1 logMessage)
    {
//        System.out.println(observers.size());
        for(Observer2 observer : observers) {
            observer.write(logMessage);
        }
    }
}
