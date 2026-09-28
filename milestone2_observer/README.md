# Milestone 2 - Observer

A BrewHub order goes queued, brewing, ready, and everyone wants to react to that: the kitchen needs it on a display, the customer's mobile app needs a notification, the stockroom needs to count the cup and beans when the drink is handed over. We used the Observer pattern because these three things change at different times and in different places, and we did not want the kitchen to be responsible for telling the customer and the stockroom about the order too.

We chose a **push** model: the publisher pushes `orderId`, `status` and `total` straight into every observer's `update`. Pull would make each observer keep a reference to the publisher and ask it for the latest status, which forces every observer to know the publisher really well and repeat the same lookup. Pushing the whole event in one call means the observers stay dumb and decoupled, which is what we want for a small demo like this.

Design decisions: `OrderStatusPublisher` keeps an `ArrayList` of observers (we took the book's `for` loop over the list); removing an observer at runtime is a plain `removeObserver` call; and the publisher holds no per-order state, it just relays each event. The three observers each react in their own way to the same pushed data, which is why only one of them is ever responsible for the app notification.

## Compile and run

```
javac -d out milestone2_observer\*.java
java -cp out milestone2_observer.Main
```

(On macOS/Linux use `milestone2_observer/*.java`.) Java 17 is required.