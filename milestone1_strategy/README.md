# Milestone 1 - Strategy

BrewHub wants several checkout pricing schemes - student discount, happy-hour pricing, loyalty-tier pricing, and plain "no discount" - and new schemes keep arriving. The price is the part of the order that changes most, so we kept the rules out of `Order` and made each scheme a strategy.

What's in the package:
- `PricingStrategy` - the interface with one method, `calculateTotal(subtotal)`
- `StudentDiscount`, `HappyHourPricing`, `LoyaltyPoints` - three concrete strategies
- `NoDiscount` - the default strategy for orders with no discount
- `Order` - holds a `PricingStrategy` field and delegates `getTotal()` to it; `setPricing()` swaps the strategy at runtime (e.g. a loyalty-tier upgrade mid-session)
- `Main` - demo: prices the same order with every strategy, then swaps strategies while the order is still open

Why not just use if/else? A chain of if/else inside `getTotal()` works today, but every new scheme means editing `Order`, and one wrong branch could break every other scheme. The order could not change its pricing mid-session either. As a strategy, the order never knows the rules, it just asks the strategy it holds, and a new scheme is a new class rather than a new branch.

## Compile and run

```
javac -d out milestone1_strategy\*.java
java -cp out milestone1_strategy.Main
```

On macOS/Linux use `milestone1_strategy/*.java`. Java 17 is required.