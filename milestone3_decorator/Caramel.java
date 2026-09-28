package milestone3_decorator;

public class Caramel extends CondimentDecorator {
    public Caramel(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return beverage.cost() + 0.30;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Caramel";
    }
}