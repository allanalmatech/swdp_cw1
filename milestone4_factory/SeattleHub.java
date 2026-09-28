package milestone4_factory;

public class SeattleHub extends RoastingHub {
    private IngredientFactory ingredientFactory = new SeattleIngredientFactory();

    public SeattleHub() {
        super("Seattle");
    }

    public IngredientFactory getIngredientFactory() {
        return ingredientFactory;
    }

    public Beans createBeans() {
        // The Factory Method hands the job to the regional Abstract Factory,
        // so a Seattle hub can only ever be made from Seattle parts.
        return ingredientFactory.createBeans();
    }
}