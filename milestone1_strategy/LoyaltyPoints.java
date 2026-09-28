package milestone1_strategy;

public class LoyaltyPoints implements PricingStrategy {
    private int points;

    public LoyaltyPoints(int points) {
        this.points = points;
    }

    public double calculateTotal(double subtotal) {
        double discount = points * 0.05;
        if (discount > subtotal / 2) {
            discount = subtotal / 2; // never let loyalty wipe out more than half.
        }
        return subtotal - discount;
    }
}