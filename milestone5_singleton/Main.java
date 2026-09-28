package milestone5_singleton;

import java.util.concurrent.CountDownLatch;

public class Main {

    static final int THREADS = 6;
    static final int ORDERS_PER_THREAD = 250;
    static final double ORDER_PRICE = 4.50;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("=== Milestone 5: Singleton ===");
        System.out.println();

        final OrderLedger[] instances = new OrderLedger[THREADS];
        final CountDownLatch gate = new CountDownLatch(1);
        Thread[] workers = new Thread[THREADS];

        System.out.println("Starting " + THREADS + " threads that all call getInstance()"
                + " and record " + ORDERS_PER_THREAD + " orders each...");

        for (int i = 0; i < THREADS; i++) {
            final int workerNumber = i;
            workers[i] = new Thread(new Runnable() {
                public void run() {
                    try {
                        gate.await(); // hold everyone back so the calls happen at the same time.
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    OrderLedger ledger = OrderLedger.getInstance();
                    instances[workerNumber] = ledger;
                    for (int n = 1; n <= ORDERS_PER_THREAD; n++) {
                        ledger.recordTransaction("T" + workerNumber + "-" + n, ORDER_PRICE);
                    }
                }
            });
            workers[i].start();
        }

        gate.countDown();
        for (int i = 0; i < THREADS; i++) {
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println();

        OrderLedger ledger = OrderLedger.getInstance();
        boolean same = true;
        for (int i = 0; i < THREADS; i++) {
            long hash = System.identityHashCode(instances[i]);
            System.out.printf("  thread %d got instance identity hash %d%n", i, hash);
            if (instances[i] != ledger) {
                same = false;
            }
        }
        System.out.println("  every thread got the SAME object as this thread: " + same);
        System.out.println();

        double expected = THREADS * ORDERS_PER_THREAD * ORDER_PRICE;
        System.out.println("  expected revenue   " + String.format("%.2f", expected)
                + " over " + (THREADS * ORDERS_PER_THREAD) + " transactions");
        System.out.println("  ledger revenue     " + String.format("%.2f", ledger.getRevenue())
                + " over " + ledger.getCount() + " transactions");
        System.out.println("  final total is correct: "
                + (Math.abs(ledger.getRevenue() - expected) < 0.001
                        && ledger.getCount() == THREADS * ORDERS_PER_THREAD));
        System.out.println();
    }
}