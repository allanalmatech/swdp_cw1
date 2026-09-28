package stretch;

import java.util.ArrayList;
import milestone2_observer.KitchenDisplay;
import milestone2_observer.OrderStatusPublisher;
import milestone5_singleton.OrderLedger;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("=== Stretch: Observer + Singleton ===");
        System.out.println("The single OrderLedger from Milestone 5 is subscribed to the");
        System.out.println("OrderStatusPublisher from Milestone 2, so it only books money");
        System.out.println("when an order reaches \"ready\".");
        System.out.println();

        OrderStatusPublisher publisher = new OrderStatusPublisher();
        KitchenDisplay kitchen = new KitchenDisplay();
        OrderLedger ledger = OrderLedger.getInstance();

        publisher.registerObserver(kitchen);
        publisher.registerObserver(ledger);

        // RunAll may have run Milestone 5 first, so remember where the ledger
        // starts and print the change (stretch orders only).
        int startCount = ledger.getCount();
        double startRevenue = ledger.getRevenue();

        System.out.println("Observers: kitchen display + the shared ledger.");
        System.out.println();

        System.out.println("Order B-3001 (total 6.40) moves through the kitchen:");
        publisher.setStatus("B-3001", OrderStatusPublisher.QUEUED, 6.40);
        show(ledger, startCount, startRevenue, "after queued");
        publisher.setStatus("B-3001", OrderStatusPublisher.BREWING, 6.40);
        show(ledger, startCount, startRevenue, "after brewing");
        publisher.setStatus("B-3001", OrderStatusPublisher.READY, 6.40);
        show(ledger, startCount, startRevenue, "after ready");
        System.out.println();

        System.out.println("Order B-3002 is queued but never completed, so it is never booked:");
        publisher.setStatus("B-3002", OrderStatusPublisher.QUEUED, 9.10);
        publisher.setStatus("B-3002", OrderStatusPublisher.BREWING, 9.10);
        show(ledger, startCount, startRevenue, "after brewing (still not ready)");
        System.out.println();

        System.out.println("This demo added " + (ledger.getCount() - startCount)
                + " transaction(s) and " + String.format("%.2f", ledger.getRevenue() - startRevenue)
                + " revenue to the shared ledger.");

        ArrayList<String> transactions = ledger.getTransactions();
        if (!transactions.isEmpty()) {
            System.out.println("Newest entry: " + transactions.get(transactions.size() - 1));
        }
        System.out.println();
    }

    static void show(OrderLedger ledger, int startCount, double startRevenue, String note) {
        int newCount = ledger.getCount() - startCount;
        double newRevenue = ledger.getRevenue() - startRevenue;
        System.out.println("  " + note + ": +" + newCount + " transaction(s), +"
                + String.format("%.2f", newRevenue) + " revenue");
    }
}