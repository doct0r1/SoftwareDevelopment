package model.observer;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Subject extends Observable {

    private List<Observer> observers = new LinkedList<>();

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
        observers.add(observer);
        }
    }

    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    public void notifyObservers(Subject observable, double newBid) {
        for (Observer b: observers) {
            b.update(observable, newBid);
        }
    }
}
