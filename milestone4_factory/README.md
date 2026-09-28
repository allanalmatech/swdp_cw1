# Milestone 4 - Factory Method + Abstract Factory

BrewHub has a roasting and brewing hub in three regions, and every region makes a different set of ingredients. The base `RoastingHub` should be able to brew an order without knowing the details of the beans, the milk or the cup, because that all changes per region. We combined two factory patterns. The **Factory Method** is `RoastingHub.createBeans()`: the concrete hub decides which `Beans` object comes back. The **Abstract Factory** is `IngredientFactory`: one regional factory produces the whole Beans/Milk/Cup family in one place.

The design proves the "one family per factory" rule. `brewOrder` in the base class only calls `createBeans()` and `getIngredientFactory().createMilk()/createCup()`, so the hub itself never constructs a part and there is simply no code path where a Seattle hub could end up with a Bogota cup. Our `checkPartsMatch` demo builds all three parts through one factory and prints their region so you can see they always agree.

The design principle behind the Abstract Factory is the **Dependency Inversion Principle (DIP)**: high-level classes (`RoastingHub`) depend on the abstract `IngredientFactory` and abstract `Beans/Milk/Cup`, never on the concrete regional classes. Details are supplied from below, and the high-level code stays closed to which region is running today.

Design decisions: we made a third region (London) to prove the pattern scales to any new market; we used plain ASCII names (`Bogota`) in class and file names to keep `javac` happy on any machine; and we delegated each hub's `createBeans()` to its own `IngredientFactory` so beans are built in exactly one place.

## Compile and run

```
javac -d out milestone4_factory\*.java
java -cp out milestone4_factory.Main
```

(On macOS/Linux use `milestone4_factory/*.java`.) Java 17 is required.