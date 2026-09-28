package milestone3_decorator;

public class Vanilla extends CondimentDecorator {
    public Vanilla(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return beverage.cost() + 0.15;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Vanilla";
    }
}