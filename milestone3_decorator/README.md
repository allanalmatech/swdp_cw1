# Milestone 3 - Decorator

Customers build any drink from a base beverage plus any number of condiments, and the combinations are unbounded. A subclass per combination would explode, so a drink is instead built by wrapping one object in another; each layer adds its own cost and its own text to the description.

What's in the package:
- `Beverage` - the base class (`cost()`, `getDescription()`)
- `CondimentDecorator` - wraps a `Beverage`
- Bases: `Espresso`, `HouseBlend`, `Drip`, and the new `PumpkinSpiceLatte`
- Condiments: `Mocha`, `SteamedMilk`, and the new `Caramel` and `Vanilla`
- `Main` - demo: stacks four condiments on an Espresso in the order they are added, and dresses up the other bases too

What subclassing every combination would not make easy: adding a condiment is one new class and it instantly works on every existing base. We added `Caramel` and `Vanilla` (and the `PumpkinSpiceLatte` base) without touching any existing class; with the subclass approach, every new condiment would mean writing a new subclass for each base it could sit on.

## Compile and run

```
javac -d out milestone3_decorator\*.java
java -cp out milestone3_decorator.Main
```

On macOS/Linux use `milestone3_decorator/*.java`. Java 17 is required.