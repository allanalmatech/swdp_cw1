# Milestone 2 - Observer

Every BrewHub order moves queued -> brewing -> ready, and three systems need to react the moment that happens: the kitchen display, the customer's mobile app, and the inventory tracker. The subject should not need to know any of them, and new subscribers should be easy to add later.

What's in the package:
- `Subject` and `Observer` - the interfaces (register, remove, notify)
- `OrderStatusPublisher` - the concrete subject; keeps an `ArrayList` of observers and sends each event to all of them
- `KitchenDisplay`, `CustomerNotifier`, `InventoryTracker` - the three observers, each reacting in its own way
- `Main` - demo: moves orders through queued/brewing/ready, unsubscribes the notifier at runtime and shows it stops receiving events, then resubscribes it

We used the **push** model: the publisher sends the full order data (`orderId`, `status`, `total`) into every observer's `update()`. Pull would have made each observer keep a reference to the publisher and ask for the latest status, tying every observer to the subject and repeating the same lookup. Pushing the whole event in one call keeps the observers independent, and subscribing/unsubscribing is just add/remove on the subject's list.

## Compile and run

```
javac -d out milestone2_observer\*.java
java -cp out milestone2_observer.Main
```

On macOS/Linux use `milestone2_observer/*.java`. Java 17 is required.