# Stretch - Observer + Singleton

The stretch goal wires Milestone 2 and Milestone 5 together: the singleton `OrderLedger` is registered as an Observer of `OrderStatusPublisher`, exactly the same ledger a cashier and the website share. That means the same object that is safely shared across threads quietly listens to every order event too, so there is only one place money is counted.

The important behaviour is the filter: `OrderLedger.update` records a transaction only when the status equals `ready`. A queued or brewing order has not been handed over, so it must not count as revenue yet. The demo pushes one order all the way through and shows the ledger stays flat at queued and brewing, then books once at ready, and shows a second order that never finishes never appears in the ledger.

Design decisions: `OrderLedger` already implemented `Observer` from Milestone 2, so no new glue class was needed and the stretch demo is just a `registerObserver(ledger)` call. Because all demos can run in one JVM through `RunAll`, Milestone 5 may have recorded transactions first, so the stretch demo prints the *change* in the ledger rather than a total.

## Compile and run

The stretch goal reuses Milestones 2 and 5, so compile all three:

```
javac -d out milestone2_observer\*.java milestone5_singleton\*.java stretch\*.java
java -cp out stretch.Main
```

(On macOS/Linux use `/` instead of `\`.) Java 17 is required.