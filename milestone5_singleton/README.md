# Milestone 5 - Singleton

Every checkout thread and the website write their transactions into one central `OrderLedger` used for accounting reconciliation. Two ledger instances would silently double-count revenue, so the ledger is a Singleton: a private constructor plus a single `getInstance()`.

What's in the package:
- `OrderLedger` - the Singleton; `recordTransaction()` is `synchronized` because checkout is multithreaded; it also implements `Observer` from Milestone 2 so the ledger can be subscribed to the publisher
- `Main` - demo: six threads call `getInstance()` at the same time, all receive the same object, and the final total is exactly right

For thread safety we chose **eager instantiation**. `getInstance()` is called for every order event, so it sits on the hot path; creating the one instance at class load turns `getInstance()` into a lock-free field read instead of paying a `synchronized` on every call. `synchronized getInstance()` and double-checked locking exist to guard a *lazy* creation, which we never need here.

Bonus - what would go wrong without the Singleton: an order recorded on the till thread and orders from the checkout thread would land in different ledgers, so the same coffee gets double-counted across the reports and the reconciliation statement sees it twice.

## Compile and run

This package imports `Observer`/`OrderStatusPublisher` from Milestone 2, so compile both:

```
javac -d out milestone2_observer\*.java milestone5_singleton\*.java
java -cp out milestone5_singleton.Main
```

On macOS/Linux use `/` instead of `\`. Java 17 is required.