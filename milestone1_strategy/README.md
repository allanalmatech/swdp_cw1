# Milestone 1 - Strategy

BrewHub sells the same coffee at different prices depending on who is buying: students get 10% off, happy hour is 20% off over a minimum spend, loyalty points come off the total, and everyone else pays full price. We used the Strategy pattern because the pricing rule is the part of the order that keeps changing, and we did not want those rules living inside `Order`.

We did not use an `if/else` chain in `getTotal()` on purpose. The moment a fourth rule appears we would have to open `Order` and edit it, and every new rule would be another branch in the same method, so a mistake in the student rule could also affect the loyalty rule. Worse, the rule was baked in when the method was written, so an order could not change its mind halfway through a session. With a strategy the order just holds a `PricingStrategy` and asks it, so swapping the rule at runtime is a single `setPricing` call, and we can add a brand new rule later as a new class without touching `Order` at all.

Design decisions: each strategy is its own small class so it can be reused and tested on a plain number; strategies only see the subtotal, never the order or its items; and `setPricing` is public because a cashier really does change the price mid-session.

## Compile and run

```
javac -d out milestone1_strategy\*.java
java -cp out milestone1_strategy.Main
```

(On macOS/Linux use `milestone1_strategy/*.java`.) Java 17 is required.