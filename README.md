# BrewHub Case Study - Coursework 1

Five milestones of the Head First Design Patterns patterns applied to a coffee-shop
order flow (Strategy, Observer, Decorator, Factory Method + Abstract Factory, Singleton),
plus a stretch goal that wires Observer and Singleton together. Plain Java 17, standard
library only. It compiles with a single `javac` command.

## File tree

```
coursework_1/
  RunAll.java                              top-level terminal menu
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

## Compile everything

From `coursework_1`:

```
javac -d out RunAll.java milestone1_strategy\*.java milestone2_observer\*.java milestone3_decorator\*.java milestone4_factory\*.java milestone5_singleton\*.java stretch\*.java
```

On macOS/Linux replace `\` with `/`. Java 17 is required (any version 17+ works).

## Run

All demos from one menu:

```
java -cp out RunAll
```

Each milestone on its own:

```
java -cp out milestone1_strategy.Main
java -cp out milestone2_observer.Main
java -cp out milestone3_decorator.Main
java -cp out milestone4_factory.Main
java -cp out milestone5_singleton.Main
java -cp out stretch.Main
```

Note: milestones 2, 3 and 4 are self-contained. Milestones 5 and the stretch re-use
Milestone 2's `Observer`/`OrderStatusPublisher`, which is why the compile command above
always includes `milestone2_observer\*.java`.
