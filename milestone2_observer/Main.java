package milestone2_observer;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("=== Milestone 2: Observer ===");
        System.out.println();

        OrderStatusPublisher publisher = new OrderStatusPublisher();
        KitchenDisplay kitchen = new KitchenDisplay();
        CustomerNotifier customer = new CustomerNotifier();
        InventoryTracker stock = new InventoryTracker();

        System.out.println("Three observers subscribe:");
        publisher.registerObserver(kitchen);
        publisher.registerObserver(customer);
        publisher.registerObserver(stock);
        System.out.println();

        System.out.println("Order B-2001 moves through the kitchen:");
        publisher.setStatus("B-2001", OrderStatusPublisher.QUEUED, 7.50);
        publisher.setStatus("B-2001", OrderStatusPublisher.BREWING, 7.50);
        publisher.setStatus("B-2001", OrderStatusPublisher.READY, 7.50);
        System.out.println();

        System.out.println("The notifier is unsubscribed at runtime (customer muted app notifications):");
        publisher.removeObserver(customer);
        System.out.println("  observers left: " + publisher.observerCount());
        publisher.setStatus("B-2002", OrderStatusPublisher.QUEUED, 5.40);
        publisher.setStatus("B-2002", OrderStatusPublisher.BREWING, 5.40);
        publisher.setStatus("B-2002", OrderStatusPublisher.READY, 5.40);
        System.out.println("  no [app] lines above: the notifier is gone");
        System.out.println();

        System.out.println("The notifier subscribes again for the next order:");
        publisher.registerObserver(customer);
        publisher.setStatus("B-2003", OrderStatusPublisher.QUEUED, 4.80);
        System.out.println();

        System.out.println("While one order turned ready, the tracker saw orders served: "
                + stock.getReadyOrders());
        System.out.println();
    }
}