package milestone4_factory;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("=== Milestone 4: Factory Method + Abstract Factory ===");
        System.out.println();

        RoastingHub[] hubs = {
                new SeattleHub(),
                new BogotaHub(),
                new LondonHub()
        };
        String[] drinks = { "Flat White", "Cambio", "Cortado" };
        double[] prices = { 4.50, 3.80, 5.20 };

        for (int i = 0; i < hubs.length; i++) {
            RoastingHub hub = hubs[i];
            hub.brewOrder(drinks[i], prices[i]);
            checkPartsMatch(hub);
            System.out.println();
        }

        System.out.println("A hub can never get mismatched parts: brewOrder() and createBeans()");
        System.out.println("only ever call the hub's own ingredient factory, so there is no way");
        System.out.println("to give the Bogota hub a Seattle milk.");
        System.out.println();
    }

    // Builds the family through the factory and checks every part matches the hub region.
    static void checkPartsMatch(RoastingHub hub) {
        IngredientFactory factory = hub.getIngredientFactory();
        String region = hub.getCity();

        Beans beans = factory.createBeans();
        Milk milk = factory.createMilk();
        Cup cup = factory.createCup();

        boolean ok = beans.getRegion().equals(region)
                && milk.getRegion().equals(region)
                && cup.getRegion().equals(region);
        System.out.println("  all parts claim region \"" + region
                + "\" -> nothing mixed up: " + ok);
    }
}