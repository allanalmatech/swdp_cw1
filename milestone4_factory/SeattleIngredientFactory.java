package milestone4_factory;

public class SeattleIngredientFactory implements IngredientFactory {
    public Beans createBeans() {
        return new SeattleBeans();
    }

    public Milk createMilk() {
        return new SeattleMilk();
    }

    public Cup createCup() {
        return new SeattleCup();
    }
}