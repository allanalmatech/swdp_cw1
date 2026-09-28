package milestone4_factory;

public abstract class RoastingHub {
    private String city;

    protected RoastingHub(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    // Abstract Factory: every hub owns exactly one regional ingredient factory.
    public abstract IngredientFactory getIngredientFactory();

    // Factory Method: the hub asks for beans and each subclass decides
    // which beans its region produces.
    public abstract Beans createBeans();

    public void brewOrder(String drink, double price) {
        Beans beans = createBeans();
        Milk milk = getIngredientFactory().createMilk();
        Cup cup = getIngredientFactory().createCup();

        System.out.println(city + " hub brews " + drink
                + " for " + String.format("%.2f", price));
        System.out.println("  " + beans.getDescription());
        System.out.println("  " + milk.getDescription());
        System.out.println("  " + cup.getDescription());
    }
}