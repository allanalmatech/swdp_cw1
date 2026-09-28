package milestone3_decorator;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("=== Milestone 3: Decorator ===");
        System.out.println();

        System.out.println("A base beverage, no condiments:");
        Beverage espresso = new Espresso();
        print(espresso);
        System.out.println();

        System.out.println("Each condiment wraps the previous one, in the order it is added:");
        Beverage drink = new Espresso();
        drink = new Mocha(drink);
        print(drink, "after mocha");
        drink = new SteamedMilk(drink);
        print(drink, "after steamed milk");
        drink = new Caramel(drink);
        print(drink, "after caramel");
        drink = new Vanilla(drink);
        print(drink, "all four condiments");
        System.out.println();

        System.out.println("The same condiments on other bases:");
        Beverage house = new HouseBlend();
        house = new Vanilla(house);
        house = new Caramel(house);
        print(house, "House Blend");

        Beverage drip = new Drip();
        drip = new SteamedMilk(drip);
        drip = new Caramel(drip);
        print(drip, "Drip");

        Beverage seasonal = new PumpkinSpiceLatte();
        seasonal = new SteamedMilk(seasonal);
        seasonal = new Mocha(seasonal);
        seasonal = new Vanilla(seasonal);
        print(seasonal, "seasonal special");
        System.out.println();
    }

    static void print(Beverage beverage) {
        System.out.printf("  %-52s cost %5.2f\n", beverage.getDescription(), beverage.cost());
    }

    static void print(Beverage beverage, String note) {
        System.out.printf("  %-42s %-10s cost %5.2f\n",
                beverage.getDescription(), note, beverage.cost());
    }
}