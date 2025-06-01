package Observer2;

import Logging1.LogMessage1;

import java.util.*;


public class Subject1 {

    List<Observer2> map = new ArrayList<>();

    public void addObserver( Observer2 logObserver){
        map.add(logObserver);
    }

    public void removeObserver(Observer2 logObserver)
    {
        map.remove(logObserver);
    }

    public void notifyAllObserver(LogMessage1 logMessage)
    {
        System.out.println(map.size());
        for(Observer2 observer : map) {
            observer.write(logMessage);
        }
    }
}
