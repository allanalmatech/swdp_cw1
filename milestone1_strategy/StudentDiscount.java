package milestone1_strategy;

public class StudentDiscount implements PricingStrategy {
    private double rate;

    public StudentDiscount(double rate) {
        this.rate = rate;
    }

    public double calculateTotal(double subtotal) {
        return subtotal - subtotal * rate;
    }
}