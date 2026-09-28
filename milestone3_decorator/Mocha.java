package milestone3_decorator;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return beverage.cost() + 0.20;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}