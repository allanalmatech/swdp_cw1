# BrewHub Case Study - Coursework 1

One growing codebase for a multi-hub coffee-roasting and ordering platform, applying a different design pattern per milestone (Head First Design Patterns chapters 1-5) plus a stretch goal that wires two patterns together. Plain Java 17, standard library only, compiles with a single `javac` command.

## File tree

```
coursework_1/
  RunAll.java                              terminal menu for all demos
  README.md                                this file
  milestone1_strategy/
    PricingStrategy.java  StudentDiscount.java  HappyHourPricing.java
    LoyaltyPoints.java    NoDiscount.java       Order.java
    Main.java             README.md
  milestone2_observer/
    Observer.java  Subject.java  OrderStatusPublisher.java
    KitchenDisplay.java  CustomerNotifier.java  InventoryTracker.java
    Main.java     README.md
  milestone3_decorator/
    Beverage.java  CondimentDecorator.java
    Espresso.java  HouseBlend.java  Drip.java  PumpkinSpiceLatte.java
    Mocha.java  SteamedMilk.java  Caramel.java  Vanilla.java
    Main.java     README.md
  milestone4_factory/
    Beans.java  Milk.java  Cup.java  IngredientFactory.java  RoastingHub.java
    SeattleBeans.java  SeattleMilk.java  SeattleCup.java  SeattleHub.java
    SeattleIngredientFactory.java
    BogotaBeans.java   BogotaMilk.java   BogotaCup.java   BogotaHub.java
    BogotaIngredientFactory.java
    LondonBeans.java   LondonMilk.java   LondonCup.java   LondonHub.java
    LondonIngredientFactory.java
    Main.java     README.md
  milestone5_singleton/
    OrderLedger.java  Main.java  README.md
  stretch/
    Main.java  README.md
```

## Compile and run

From `coursework_1`:

```
javac -d out RunAll.java milestone1_strategy\*.java milestone2_observer\*.java milestone3_decorator\*.java milestone4_factory\*.java milestone5_singleton\*.java stretch\*.java
```

On macOS/Linux replace `\` with `/`. Java 17 (or newer) is required.

Run everything from one menu:

```
java -cp out RunAll
```

Or each demo on its own (Milestone 5 and the stretch also import Milestone 2's `Observer` classes):

```
java -cp out milestone1_strategy.Main
java -cp out milestone2_observer.Main
java -cp out milestone3_decorator.Main
java -cp out milestone4_factory.Main
java -cp out milestone5_singleton.Main
java -cp out stretch.Main
```

## Why and how, milestone by milestone

### Milestone 1 - Strategy
**Why:** pricing schemes (student, happy hour, loyalty, none) are the part of an order that keeps changing, and rules hidden in an if/else chain would force editing `Order` for every new scheme.
**How:** `Order` holds a `PricingStrategy` and delegates `getTotal()` to `calculateTotal(subtotal)`. The three concrete strategies (`StudentDiscount`, `HappyHourPricing`, `LoyaltyPoints`) and the default `NoDiscount` each close off the rule in their own class, and `setPricing()` lets the cashier swap the scheme while the order is still open.

### Milestone 2 - Observer
**Why:** queued -> brewing -> ready events must reach the kitchen display, the customer's app, and the inventory tracker, and the order service should not know any of them - new subscribers should join later without touching the service.
**How:** `OrderStatusPublisher` implements `Subject` (register/remove/notify) and pushes each event (`orderId`, `status`, `total`) to its observer list. `KitchenDisplay`, `CustomerNotifier` and `InventoryTracker` each react in their own way; the demo unsubscribes the notifier at runtime (it stops receiving) and subscribes it again.

### Milestone 3 - Decorator
**Why:** drinks are a base plus any number of condiments, so the combination space is unbounded and a subclass per combination would explode.
**How:** `CondimentDecorator` wraps a `Beverage` and every layer adds its own cost and appends its own name in `getDescription()`, so the description reflects the order the condiments were added. The demo stacks four condiments on one Espresso and shows the cost growing layer by layer. We added two new condiments (`Caramel`, `Vanilla`) and one new base (`PumpkinSpiceLatte`) as plain new classes, without touching any existing class.

### Milestone 4 - Factory Method + Abstract Factory
**Why:** each hub sources its own beans, milk, and cups locally, and a hub must never combine parts from two regions; a new hub should be cheap to add.
**How:** `RoastingHub.createBeans()` is the Factory Method each hub overrides, and `getIngredientFactory()` is the Abstract Factory providing the Beans/Milk/Cup family. Every hub only ever uses its own factory, so mismatched parts are impossible; `Main` prints the region on each part and confirms they all match. Third region chosen for M4: London.

### Milestone 5 - Singleton
**Why:** accounting needs exactly one `OrderLedger`; two ledgers would double-count revenue, and checkout runs on multiple threads.
**How:** private constructor + eager `getInstance()` (fastest for the hot path), with `recordTransaction()` `synchronized` for the multithreaded checkout. The demo starts six threads that all call `getInstance()`, proves they share the same object, and checks the final total.

### Stretch goal - Observer + Singleton
**Why:** the ledger should book a transaction only when an order is actually handed over, without the order service knowing the ledger exists.
**How:** `OrderLedger` implements Milestone 2's `Observer` and subscribes to `OrderStatusPublisher`; it records only when the status is "ready". The demo shows queued and brewing events changing nothing, and a "ready" event adding one transaction.