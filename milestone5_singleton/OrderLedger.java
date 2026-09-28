package milestone5_singleton;

import java.util.ArrayList;
import milestone2_observer.Observer;
import milestone2_observer.OrderStatusPublisher;

public class OrderLedger implements Observer {
    // Eagerly created when the class loads, so all threads share the one ledger.
    private static final OrderLedger INSTANCE = new OrderLedger();

    private ArrayList<String> transactions = new ArrayList<String>();
    private double revenue;

    private OrderLedger() {
    }

    public static OrderLedger getInstance() {
        return INSTANCE;
    }

    public synchronized void recordTransaction(String orderId, double amount) {
        transactions.add(orderId + " -> " + String.format("%.2f", amount));
        revenue = revenue + amount;
    }

    // The ledger is also an Observer (used by the stretch goal) and only books
    // money once an order is actually handed over.
    public synchronized void update(String orderId, String status, double total) {
        if (status.equals(OrderStatusPublisher.READY)) {
            recordTransaction(orderId, total);
        }
    }

    public synchronized int getCount() {
        return transactions.size();
    }

    public synchronized double getRevenue() {
        return revenue;
    }

    public synchronized ArrayList<String> getTransactions() {
        return new ArrayList<String>(transactions);
    }
}