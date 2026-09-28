package milestone2_observer;

public interface Observer {
    void update(String orderId, String status, double total);
}