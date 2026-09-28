# Milestone 5 - Singleton

Every cash machine and the website write orders into the same money ledger. If each one made its own ledger, the order from the till and the order from the app would be counted separately and revenue would be wrong. We made `OrderLedger` a Singleton: the constructor is private, there is a single `getInstance()`, and we pinned the instance in a `static final` field.

For thread safety we chose **eager instantiation**. `getInstance()` is called on every single order event, so the ledger lives on the hot path; with eager creation the one-time cost is paid at class load and `getInstance()` is a lock-free field access afterwards. `synchronized getInstance()` would put a `synchronized` on every call just to hand back the same object, and double-checked locking buys no extra safety here for the lock it costs, so the simplest correct answer wins.

Recording is `synchronized` on `recordTransaction` and `update` because many threads really do call it at once (Milestone 5's demo uses 6 threads and every order must count exactly once). The bonus: if two ledgers existed, the same coffee handed over once would show up in both books, so revenue would be double-counted across the reports and the count of served orders would be wrong.

One forward-looking choice: we let `OrderLedger` implement `Observer` from Milestone 2 so the stretch goal can subscribe the ledger straight to the publisher, reusing both earlier milestones instead of rewriting them.

## Compile and run

Milestone 5 depends on the `Observer` interface from Milestone 2, so compile both:

```
javac -d out milestone2_observer\*.java milestone5_singleton\*.java
java -cp out milestone5_singleton.Main
```

(On macOS/Linux use `/` instead of `\`.) Java 17 is required. The main thread waits on `CountDownLatch` and `Thread.join`, so the threads are known to have finished before the totals are read.