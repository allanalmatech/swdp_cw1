package milestone4_factory;

// Regional product family: beans, milk and cup all come from the same place.
public interface IngredientFactory {
    Beans createBeans();

    Milk createMilk();

    Cup createCup();
}