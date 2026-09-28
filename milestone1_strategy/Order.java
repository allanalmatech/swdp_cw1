package milestone1_strategy;

import java.util.ArrayList;

public class Order {
    private String orderId;
    private ArrayList<String> items = new ArrayList<String>();
    private double subtotal;
    private PricingStrategy pricing;

    public Order(String orderId, PricingStrategy pricing) {
        this.orderId = orderId;
        this.pricing = pricing;
    }

    public void addItem(String item, double price) {
        items.add(item);
        subtotal = subtotal + price;
        System.out.println("  added " + item + "   subtotal is now "
                + String.format("%.2f", subtotal));
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setPricing(PricingStrategy pricing) {
        this.pricing = pricing;
    }

    // The order does not know the pricing rules, it just asks the strategy it holds.
    public double getTotal() {
        return pricing.calculateTotal(subtotal);
    }

    public void printItems() {
        System.out.println("  Order " + orderId + " contains:");
        for (String item : items) {
            System.out.println("    - " + item);
        }
    }
}