# Milestone 3 - Decorator

At BrewHub a drink is a base with any number of added extras: mocha, steamed milk, caramel, vanilla, and more coming next season. The problem was that a plain Beverage subclass for every possible combination (EspressoWithMochaSteamedMilkCaramel...) would have exploded into dozens of near-identical classes, and adding one new condiment would mean adding a new subclass for every drink it could sit on. The Decorator pattern wraps a drink in a condiment, and each layer adds its own cost and description while delegating to whatever is inside it.

One thing this makes easy that subclassing every combination would not: we added `Caramel` and `Vanilla` as two new classes, and they instantly work on Espresso, House Blend, the seasonal special, and any future base — we never had to touch an existing class. With the subclass approach, adding three condiments to five drinks would have meant writing `C(n, k)` classes by hand.

Design decisions: `CondimentDecorator` keeps the book's shape (just a `Beverage` field), each concrete condiment contributes a fixed price to `cost()` and appends its name in `getDescription()`, so the printed description always shows the order the condiments were added. We also note that Milestone 3 does not reimplement Milestone 1's pricing: that was order-level discounting with strategies, while this is purely about building a drink line by line and summing its ingredients.

## Compile and run

```
javac -d out milestone3_decorator\*.java
java -cp out milestone3_decorator.Main
```

(On macOS/Linux use `milestone3_decorator/*.java`.) Java 17 is required.