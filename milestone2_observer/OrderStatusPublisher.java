package milestone2_observer;

import java.util.ArrayList;

public class OrderStatusPublisher implements Subject {
    public static final String QUEUED = "queued";
    public static final String BREWING = "brewing";
    public static final String READY = "ready";

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public void setStatus(String orderId, String status, double total) {
        System.out.println("  -> " + orderId + " is now " + status);
        notifyObservers(orderId, status, total);
    }

    public int observerCount() {
        return observers.size();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String orderId, String status, double total) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(orderId, status, total);
        }
    }
}