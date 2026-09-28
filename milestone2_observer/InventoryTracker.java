package milestone2_observer;

public class InventoryTracker implements Observer {
    private int readyOrders;

    public void update(String orderId, String status, double total) {
        if (status.equals(OrderStatusPublisher.READY)) {
            readyOrders = readyOrders + 1;
        }
        System.out.println("  [stock     ] " + orderId + " " + status
                + "  (orders served so far: " + readyOrders + ")");
    }

    public int getReadyOrders() {
        return readyOrders;
    }
}