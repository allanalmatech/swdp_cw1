package milestone4_factory;

public class LondonIngredientFactory implements IngredientFactory {
    public Beans createBeans() {
        return new LondonBeans();
    }

    public Milk createMilk() {
        return new LondonMilk();
    }

    public Cup createCup() {
        return new LondonCup();
    }
}