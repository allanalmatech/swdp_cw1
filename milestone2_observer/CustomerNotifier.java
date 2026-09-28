package milestone2_observer;

public class CustomerNotifier implements Observer {
    public void update(String orderId, String status, double total) {
        if (status.equals(OrderStatusPublisher.QUEUED)) {
            System.out.println("  [app       ] " + orderId + " confirmed, "
                    + String.format("%.2f", total) + ", around 4 minutes");
        } else if (status.equals(OrderStatusPublisher.BREWING)) {
            System.out.println("  [app       ] " + orderId + " is being made now");
        } else {
            System.out.println("  [app       ] " + orderId + " is ready, come to the counter");
        }
    }
}