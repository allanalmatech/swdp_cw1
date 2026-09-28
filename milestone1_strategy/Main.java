package milestone1_strategy;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("=== Milestone 1: Strategy ===");
        System.out.println();

        PricingStrategy student = new StudentDiscount(0.10);
        PricingStrategy happyHour = new HappyHourPricing(0.20, 8.00);
        PricingStrategy loyalty = new LoyaltyPoints(35);
        PricingStrategy noDiscount = new NoDiscount();

        Order order = new Order("B-1001", student);
        System.out.println("Order B-1001 at BrewHub:");
        order.addItem("2 x Espresso", 5.00);
        order.addItem("Blueberry Muffin", 2.00);
        order.addItem("1 x Filter Coffee", 3.00);
        System.out.println();

        System.out.println("The same order, priced with each strategy:");
        show(order, "student discount (10% off)", student);
        show(order, "happy hour (20% off, min 8.00)", happyHour);
        show(order, "loyalty card (35 points)", loyalty);
        show(order, "no discount", noDiscount);
        System.out.println();

        System.out.println("The order is still open, so the strategy is swapped at runtime:");
        show(order, "starts as a student", student);
        show(order, "brings out a loyalty card", loyalty);
        show(order, "5pm, happy hour starts", happyHour);
        show(order, "staff accepts no discount", noDiscount);
        System.out.println();
    }

    static void show(Order order, String note, PricingStrategy pricing) {
        order.setPricing(pricing);
        System.out.printf("  %-32s total %6.2f\n", note, order.getTotal());
    }
}