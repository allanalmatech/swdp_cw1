# Milestone 4 - Factory Method + Abstract Factory

BrewHub runs roasting hubs in different regions, and each hub sources its own beans, milk, and cups locally. A hub must never combine parts from two regions - Seattle beans in a Bogota cup would break the regional sourcing contract - and adding a new hub should stay cheap.

What's in the package:
- `RoastingHub` - abstract base; `createBeans()` is the Factory Method every hub overrides
- `IngredientFactory` - the Abstract Factory that produces the whole Beans/Milk/Cup family per region
- Three regional sets (`Beans`, `Milk`, `Cup`, `Hub`, `IngredientFactory`): `Seattle`, `Bogota`, and `London`
- `Main` - demo: brews one order per hub and checks that every part claims the hub's own region

`brewOrder()` only ever calls `createBeans()` and its own `getIngredientFactory()`, so there is no code path where one region's parts can be mixed with another's; the demo prints `nothing mixed up: true` for every hub. The design principle the Abstract Factory enforces is the **Dependency Inversion Principle**: the high-level `RoastingHub` depends on the abstract `IngredientFactory` and abstract `Beans`/`Milk`/`Cup`, never on the concrete regional classes.

## Compile and run

```
javac -d out milestone4_factory\*.java
java -cp out milestone4_factory.Main
```

On macOS/Linux use `milestone4_factory/*.java`. Java 17 is required.