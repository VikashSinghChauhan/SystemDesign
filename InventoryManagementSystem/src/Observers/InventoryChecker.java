package Observers;

import Product.Product;

import java.util.*;
public class InventoryChecker {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    public void notifyObservers(Product product)
    {
        for(Observer observer : observers)
        {
            observer.onLowStock(product);
        }
    }
}
