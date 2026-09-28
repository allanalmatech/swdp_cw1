package milestone4_factory;

public class LondonHub extends RoastingHub {
    private IngredientFactory ingredientFactory = new LondonIngredientFactory();

    public LondonHub() {
        super("London");
    }

    public IngredientFactory getIngredientFactory() {
        return ingredientFactory;
    }

    public Beans createBeans() {
        return ingredientFactory.createBeans();
    }
}