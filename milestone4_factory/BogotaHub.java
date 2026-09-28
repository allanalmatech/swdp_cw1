package milestone4_factory;

public class BogotaHub extends RoastingHub {
    private IngredientFactory ingredientFactory = new BogotaIngredientFactory();

    public BogotaHub() {
        super("Bogota");
    }

    public IngredientFactory getIngredientFactory() {
        return ingredientFactory;
    }

    public Beans createBeans() {
        return ingredientFactory.createBeans();
    }
}