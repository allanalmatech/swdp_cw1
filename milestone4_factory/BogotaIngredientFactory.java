package milestone4_factory;

public class BogotaIngredientFactory implements IngredientFactory {
    public Beans createBeans() {
        return new BogotaBeans();
    }

    public Milk createMilk() {
        return new BogotaMilk();
    }

    public Cup createCup() {
        return new BogotaCup();
    }
}