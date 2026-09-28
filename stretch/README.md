# Stretch - Observer + Singleton

The stretch goal wires Milestone 2 and Milestone 5 together: the shared `OrderLedger` subscribes to `OrderStatusPublisher` as an Observer, so the same ledger that is shared across threads also listens to order events and books a transaction only when an order reaches "ready". A queued or brewing order has not been handed over, so it records nothing.

What's in the package:
- `Main` - demo: pushes order B-3001 through queued/brewing/ready and shows the ledger gains exactly one transaction, at "ready"; order B-3002 never finishes and is never booked

Because every demo can run in the same JVM from `RunAll`, Milestone 5 may already have recorded transactions, so the demo prints the *change* in the ledger rather than a total.

## Compile and run

The stretch reuses Milestones 2 and 5, so compile all three:

```
javac -d out milestone2_observer\*.java milestone5_singleton\*.java stretch\*.java
java -cp out stretch.Main
```

On macOS/Linux use `/` instead of `\`. Java 17 is required.