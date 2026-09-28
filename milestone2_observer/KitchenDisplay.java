package milestone2_observer;

public class KitchenDisplay implements Observer {
    public void update(String orderId, String status, double total) {
        System.out.println("  [kitchen  ] " + orderId + " " + status + " - next: " + nextStep(status));
    }

    private String nextStep(String status) {
        if (status.equals(OrderStatusPublisher.QUEUED)) {
            return "start the grinder";
        }
        if (status.equals(OrderStatusPublisher.BREWING)) {
            return "pour the milk, pull the shot";
        }
        return "hand the cup over the counter";
    }
}